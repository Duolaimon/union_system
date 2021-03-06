package org.duol.union.controller;

import org.duol.union.dao.CommitteeDao;
import org.duol.union.dao.DepartmentDao;
import org.duol.union.dao.LeaderDao;
import org.duol.union.dao.TeamDao;
import org.duol.union.entity.Committee;
import org.duol.union.entity.Department;
import org.duol.union.entity.Leader;
import org.duol.union.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Duolaimon
 *         17-6-23 下午5:02
 *         成员管理控制,包括：
 *          1)职工(Committee)
 *          2)领导(Leader)
 *          3)部门(Department)
 */
@Controller
@RequestMapping("/user")
@SuppressWarnings("unused")
public class UserController {
    private final LeaderDao leaderDao;
    private final CommitteeDao committeeDao;
    private final DepartmentDao departmentDao;
    private final TeamDao teamDao;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public UserController(LeaderDao leaderDao, CommitteeDao committeeDao, DepartmentDao departmentDao, TeamDao teamDao) {
        this.leaderDao = leaderDao;
        this.committeeDao = committeeDao;
        this.departmentDao = departmentDao;
        this.teamDao = teamDao;
    }

    /**
     * 展示领导管理界面
     * @param model 领导信息
     * @return      领导管理界面
     */
    @RequestMapping("/showLeaderBody")
    public String showLeaderBody(Model model) {
        List<Leader> leaderList = leaderDao.queryLeaderList();
        model.addAttribute("leaderList", leaderList);
        model.addAttribute("sdf", sdf);
        return "body/leaderBody";
    }

    /**
     * 展示用户管理页面
     *
     * @param model 用户信息
     * @return 用户管理页面
     */
    @RequestMapping("/showCommitteeBody")
    public String showCommitteeBody(Model model) {
        List<Committee> committeeList = committeeDao.queryCommitteeList();
        model.addAttribute("committeeList", committeeList);
        return "body/committeeBody";
    }

    /**
     * 展示部门管理页面
     *
     * @param model 部门信息
     * @return 部门管理页面
     */
    @RequestMapping("/showDepartmentBody")
    public String showDepartmentBody(Model model) {
        List<Department> departmentList = departmentDao.queryDepartmentList();
        model.addAttribute("departmentList", departmentList);
        return "body/departmentBody";
    }

    /**
     * 展示队伍管理界面
     * @param model 队伍信息
     * @return  队伍管理界面
     */
    @RequestMapping("/showTeamBody")
    public String showTeamBody(Model model) {
        List<Team> teamList = teamDao.queryTeamList();
        model.addAttribute("teamList", teamList);
        return "body/teamBody";
    }

    /**
     * 删除领导
     * @param leaderId 领导id
     */
    @GetMapping("/{leaderId}/deleteLeader")
    public void deleteLeader(@PathVariable("leaderId") String leaderId) {
        leaderDao.deleteLeader(Integer.valueOf(leaderId));
    }

    /**
     * 更新领导信息
     * @param leaderId          领导id号
     * @param leaderPassword    领导密码
     * @param leaderName        领导名字
     */
    @PostMapping("/{leaderId}/alterLeader")
    public void alterLeader(@PathVariable("leaderId") String leaderId,
                            @RequestParam(value = "leaderPass", defaultValue = "") String leaderPassword,
                            @RequestParam(value = "leaderName", defaultValue = "") String leaderName) {
        leaderDao.updateLeader(Integer.valueOf(leaderId), leaderPassword, leaderName);
    }

    /**
     * 新增领导信息
     * @param leaderId  领导id号
     */
    @PostMapping("/{leaderId}/addLeader")
    public void addLeader(@PathVariable("leaderId") String leaderId,
                          @RequestParam("leaderPass") String leaderPass,
                          @RequestParam("leaderName") String leaderName) {
        leaderDao.insertLeader(Integer.valueOf(leaderId),leaderPass,leaderName);
    }


    /**
     * 删除指定id号的用户
     *
     * @param committeeId 用户id号
     */
    @GetMapping("/{committeeId}/deleteCommittee")
    public void deleteCommittee(@PathVariable("committeeId") String committeeId) {
        committeeDao.deleteCommitteeById(committeeId);
    }

    /**
     * 更新用户信息
     *
     * @param committeeId   用户id号
     * @param committeePass 用户密码
     * @param committeeName 用户姓名
     */
    @PostMapping("/{committeeId}/alterCommittee")
    public void alterCommittee(@PathVariable("committeeId") String committeeId,
                               @RequestParam(value = "committeePass", defaultValue = "") String committeePass,
                               @RequestParam(value = "committeeName", defaultValue = "") String committeeName,
                               @RequestParam("teamId") String teamId) {
        committeeDao.updateCommittee(committeeId, committeePass, committeeName,Integer.valueOf(teamId));
    }

    /**
     * 添加用户
     *
     * @param committeeId 用户id号
     */
    @PostMapping("/{committeeId}/addCommittee")
    public void addCommittee(@PathVariable("committeeId") String committeeId,
                             @RequestParam("committeePass") String committeePass,
                             @RequestParam("committeeName") String committeeName,
                             @RequestParam("teamId") String teamId) {
        committeeDao.insertCommittee(committeeId,committeePass,committeeName,Integer.valueOf(teamId));
    }


    /**
     * 添加一个新部门
     *
     * @param departmentId       部门id
     * @param departmentPassword 部门密码
     * @param departmentName     部门名
     */
    @PostMapping("/{departmentId}/addDepartment")
    public void addDepartment(@PathVariable("departmentId") String departmentId,
                              @RequestParam(value = "departmentPassword", defaultValue = "123456") String departmentPassword,
                              @RequestParam("departmentName") String departmentName) {
        departmentDao.insertDepartment(departmentId, departmentPassword, departmentName);
    }

    /**
     * 删除指定id号的部门
     *
     * @param departmentId 部门id号
     */
    @GetMapping("/{departmentId}/deleteDepartment")
    public void deleteDepartment(@PathVariable("departmentId") String departmentId) {
        departmentDao.deleteDepartmentById(departmentId);
    }

    /**
     * 添加队伍
     * @param teamId    队伍号
     * @param teamPass  队伍登录密码
     * @param teamName  队伍名字
     */
    @PostMapping("/{teamId}/addTeam")
    public void addTeam(@PathVariable("teamId") String teamId,
                        @RequestParam("teamPass") String teamPass,
                        @RequestParam("teamName") String teamName) {
        System.out.println("-------ADD TEAM");
        teamDao.insertTeam(Integer.valueOf(teamId), teamPass, teamName);
    }

    @GetMapping("/{teamId}/deleteTeam")
    public void deleteTeam(@PathVariable("teamId") String teamId) {
        teamDao.deleteTeam(Integer.valueOf(teamId));
    }

    @PostMapping("/{teamId}/alterTeam")
    public void alterTeam(@PathVariable("teamId") String teamId,
                          @RequestParam("teamPass") String teamPass,
                          @RequestParam("teamName") String teamName) {
        teamDao.updateTeam(Integer.valueOf(teamId), teamPass, teamName);
    }
}
