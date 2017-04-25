package org.duol.union.controller;

import org.duol.union.entity.Advice;
import org.duol.union.entity.Committee;
import org.duol.union.entity.Department;
import org.duol.union.service.AdviceService;
import org.duol.union.service.CommitteeService;
import org.duol.union.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author deity
 *         17-3-25 下午12:39
 *         <p>
 *         管理员进入管理界面后相关操作
 */
@Controller
@RequestMapping("/admin")
public class ManagerController {
    private final AdviceService adviceService;
    private final CommitteeService committeeService;
    private final DepartmentService departmentService;

    @Autowired
    public ManagerController(AdviceService adviceService, CommitteeService committeeService, DepartmentService departmentService) {
        this.adviceService = adviceService;
        this.committeeService = committeeService;
        this.departmentService = departmentService;
    }

    private boolean modifiedAdvice;     //advice表是否被修改
    private boolean modifiedCommittee;       //Committee表是否被修改
    private boolean modifiedDepartment;
    private List<Advice> adviceList;
    private List<Committee> committeeList;
    private List<Department> departmentList;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 登录并返回管理员主页面
     *
     * @param username 管理员账号
     * @param password 管理员密码
     * @param model    包括提案信息和用户信息
     * @return 登录成功进入manager.jsp, 否则进入failed.jsp
     */

    @PostMapping("/index")
    @SuppressWarnings("unused")
    public String managerIndex(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if ("admin".equals(username) && "admin".equals(password)) {
            adviceList = adviceService.getAdviceList();
            committeeList = committeeService.getCommitteeList();
            departmentList = departmentService.getDepartmentList();
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("adviceList", adviceList);
            model.addAttribute("committeeList", committeeList);
            model.addAttribute("sdf", sdf);
            modifiedAdvice = false;
            modifiedCommittee = false;
            modifiedDepartment = false;
            return "adviceBody";
        } else {
            return "failed";
        }
    }

    /**
     * 展示提案管理页面
     *
     * @param model 提案信息
     * @return 提案管理页面
     */
    @SuppressWarnings("unused")
    @RequestMapping("/showAdviceBody")
    public String showAdviceBody(Model model) {
        if (modifiedAdvice) {
            adviceList = adviceService.getAdviceList();
            modifiedAdvice = false;
        }
        model.addAttribute("adviceList", adviceList);
        model.addAttribute("sdf", sdf);
        return "adviceBody";
    }

    /**
     * 展示用户管理页面
     *
     * @param model 用户信息
     * @return 用户管理页面
     */
    @SuppressWarnings("unused")
    @RequestMapping("/showCommitteeBody")
    public String showCommitteeBody(Model model) {
        if (modifiedCommittee) {
            committeeList = committeeService.getCommitteeList();
        }
        model.addAttribute("committeeList", committeeList);
        return "committeeBody";
    }

    /**
     * 展示部门管理页面
     *
     * @param model 部门信息
     * @return 部门管理页面
     */
    @SuppressWarnings("unused")
    @RequestMapping("/showDepartmentBody")
    public String showDepartmentBody(Model model) {
        if (modifiedDepartment) {
            departmentList = departmentService.getDepartmentList();
        }
        model.addAttribute("departmentList", departmentList);
        return "departmentBody";
    }

    /**
     * 请求转入adviceContent.jsp
     * 页面显示选中的提案的信息
     *
     * @param id    选中的提案的id
     * @param model 包括提案信息,用户名,提案内容
     * @return 转发到adviceContent.jsp
     */
    @SuppressWarnings("unused")
    @GetMapping("/{adviceId}/content")
    public String adviceContent(@PathVariable("adviceId") Integer id, Model model) {
        Advice advice = adviceService.getById(id);
        String committeeId = advice.getUserId();
        Committee committee = committeeService.getCommitteeById(committeeId);
        String content = advice.getAdviceContent();
        String[] contents = {""};
        if (content != null && !"".equals(content)) {
            contents = content.split("\n");
        }
        List contentList = Arrays.asList(contents);
        String committeeName;
        try {
            committeeName = committee.getCommitteeName();
        } catch (NullPointerException e) {
            committeeName = "该成员信息已被删除";
        }
        model.addAttribute("advice", advice);
        model.addAttribute("committeeName", committeeName);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "adviceContent";
    }

    /**
     * 删除指定id号的提案
     *
     * @param id 提案id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{adviceId}/deleteAdvice")
    public void deleteAdvice(@PathVariable("adviceId") Integer id) {
        adviceService.deleteById(id);
        modifiedAdvice = true;
    }

    /**
     * 删除指定id号的用户
     *
     * @param committeeId 用户id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{committeeId}/deleteCommittee")
    public void deleteCommittee(@PathVariable("committeeId") String committeeId) {
        committeeService.deleteCommitteeById(committeeId);
        modifiedCommittee = true;
    }

    /**
     * 更新用户信息
     *
     * @param committeeId   用户id号
     * @param committeePass 用户密码
     * @param committeeName 用户姓名
     */
    @SuppressWarnings("unused")
    @PostMapping("/{committeeId}/alterCommittee")
    public void alterCommittee(@PathVariable("committeeId") String committeeId,
                               @RequestParam(value = "committeePass", defaultValue = "123456") String committeePass,
                               @RequestParam(value = "committeeName", defaultValue = "") String committeeName) {
        committeeService.updateCommittee(committeeId, committeePass, committeeName);
        modifiedCommittee = true;
    }

    /**
     * 添加用户
     *
     * @param committeeId 用户id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{committeeId}/addCommittee")
    public void addCommittee(@PathVariable("committeeId") String committeeId) {
        committeeService.addCommittee(committeeId);
        modifiedCommittee = true;
    }

    /**
     * 添加一个新部门
     *
     * @param departmentId       部门id
     * @param departmentPassword 部门密码
     * @param departmentName     部门名
     */
    @SuppressWarnings("unused")
    @PostMapping("/{departmentId}/addDepartment")
    public void addDepartment(@PathVariable("departmentId") String departmentId,
                              @RequestParam(value = "departmentPassword", defaultValue = "123456") String departmentPassword,
                              @RequestParam("departmentName") String departmentName) {
        departmentService.addDepartment(departmentId, departmentPassword, departmentName);
        modifiedDepartment = true;
    }

    /**
     * 删除指定id号的部门
     *
     * @param departmentId 部门id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{departmentId}/deleteDepartment")
    public void deleteDepartment(@PathVariable("departmentId") String departmentId) {
        departmentService.removeDepartmentById(departmentId);
        modifiedDepartment = true;
    }

}
