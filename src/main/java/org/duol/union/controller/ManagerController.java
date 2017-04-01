package org.duol.union.controller;

import org.duol.union.entity.Advice;
import org.duol.union.entity.User;
import org.duol.union.service.AdviceService;
import org.duol.union.service.UserService;
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
 *
 *         管理员进入管理界面后相关操作
 */
@Controller
@RequestMapping("/admin")
public class ManagerController {
    private final AdviceService adviceService;
    private final UserService userService;

    @Autowired
    public ManagerController(AdviceService adviceService, UserService userService) {
        this.adviceService = adviceService;
        this.userService = userService;
    }


    /**
     * 登录并返回管理员主页面
     * @param username  管理员账号
     * @param password  管理员密码
     * @param model     包括提案信息和用户信息
     * @return          登录成功进入manager.jsp,否则进入failed.jsp
     */
    @PostMapping("/index")
    @SuppressWarnings("unused")
    public String managerIndex(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
        if ("admin".equals(username) && "admin".equals(password)) {
            List<Advice> adviceList = adviceService.getAdviceList();
            List<User> userList = userService.getUserList();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("adviceList", adviceList);
            model.addAttribute("userList", userList);
            model.addAttribute("sdf", sdf);
            return "adviceBody";
        } else {
            return "failed";
        }
    }

    @SuppressWarnings("unused")
    @RequestMapping("/showAdviceBody")
    public String showAdviceBody(Model model) {
        List<Advice> adviceList = adviceService.getAdviceList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("adviceList", adviceList);
        model.addAttribute("sdf", sdf);
        return "adviceBody";
    }

    @SuppressWarnings("unused")
    @RequestMapping("/showUserBody")
    public String showUserBody(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "userBody";
    }

    /**
     * 请求转入adviceContent.jsp
     * 页面显示选中的提案的信息
     * @param id    选中的提案的id
     * @param model 包括提案信息,用户名,提案内容
     * @return      转发到adviceContent.jsp
     */
    @SuppressWarnings("unused")
    @GetMapping("/{adviceId}/content")
    public String adviceContent(@PathVariable("adviceId") Integer id, Model model) {
        Advice advice = adviceService.getById(id);
        //TODO: advice 为空
        String userId = advice.getUserId();
        User user = userService.getUserById(userId);
        String[] contents = advice.getContent().split("\n");
        List contentList = Arrays.asList(contents);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String userName;
        try{
            userName = user.getUserName();
        }catch (NullPointerException e){
            userName = "该成员信息已被删除";
        }
        model.addAttribute("advice", advice);
        model.addAttribute("userName",userName );
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "adviceContent";
    }

    /**
     * 删除指定id号的提案
     * @param id    提案id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{adviceId}/deleteAdvice")
    public void deleteAdvice(@PathVariable("adviceId") Integer id) {
        adviceService.deleteById(id);
    }

    /**
     * 删除指定id号的用户
     * @param userId    用户id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{userId}/deleteUser")
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUserById(userId);
    }

    /**
     * 更新用户信息
     * @param userId    用户id号
     * @param userPass  用户密码
     * @param userName  用户姓名
     */
    @SuppressWarnings("unused")
    @PostMapping("/{userId}/alterUser")
    public void alterUser(@PathVariable("userId") String userId,
                          @RequestParam("userPass") String userPass,
                          @RequestParam("userName") String userName) {
        userService.updateUser(userId, userPass, userName);
    }

    /**
     * 添加用户
     * @param userId    用户id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{userId}/addUser")
    public void addUser(@PathVariable("userId") String userId){
        userService.insertUser(userId);
    }


}
