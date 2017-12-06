package org.duol.union.controller;

import org.duol.union.dao.*;
import org.duol.union.entity.*;
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
 *         内容展示相关,包括：
 *         1)提案(Advice)
 *         2)新闻(News)
 *         3)回复(Reply)
 *         4)通知(Event)
 *         5)会议(Meeting)
 */
@Controller
@RequestMapping("/admin")
@SuppressWarnings("unused")
public class ManagerController {
    private final AdviceDao adviceDao;
    private final EventDao eventDao;
    private final CommitteeDao committeeDao;
    private final MeetingDao meetingDao;
    private final NewsDao newsDao;
    private final ReplyDao replyDao;
    private final ManageDao manageDao;
    private final OrganizationDao organizationDao;
    private final QuestionDao questionDao;
    private final RuleDao ruleDao;

    @Autowired
    public ManagerController(AdviceDao adviceDao, EventDao eventDao, CommitteeDao committeeDao, MeetingDao meetingDao, NewsDao newsDao, ReplyDao replyDao, ManageDao manageDao, OrganizationDao organizationDao, QuestionDao questionDao, RuleDao ruleDao) {
        this.adviceDao = adviceDao;
        this.eventDao = eventDao;
        this.committeeDao = committeeDao;
        this.meetingDao = meetingDao;
        this.newsDao = newsDao;
        this.replyDao = replyDao;
        this.manageDao = manageDao;
        this.organizationDao = organizationDao;
        this.questionDao = questionDao;
        this.ruleDao = ruleDao;
    }

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
        Manage manage = manageDao.queryManage(username);
        if (manage != null && manage.getManagePass().equals(password)) {
            List<Advice> adviceList = adviceDao.queryAdviceList();
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("adviceList", adviceList);
            model.addAttribute("sdf", sdf);
            return "body/adviceBody";
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
    @RequestMapping("/showAdviceBody")
    public String showAdviceBody(Model model) {
        List<Advice> adviceList = adviceDao.queryAdviceList();
        model.addAttribute("adviceList", adviceList);
        model.addAttribute("sdf", sdf);
        return "body/adviceBody";
    }

    /**
     * 请求转入adviceContent.jsp
     * 页面显示选中的提案的信息
     *
     * @param id    选中的提案的id
     * @param model 包括提案信息,用户名,提案内容
     * @return 转发到adviceContent.jsp
     */
    @GetMapping("/{adviceId}/adviceContent")
    public String adviceContent(@PathVariable("adviceId") Integer id, Model model) {
        Advice advice = adviceDao.queryAdviceById(id);
        if (advice == null) return "nullAdvice";
        String committeeId = advice.getUserId();
        Committee committee = committeeDao.queryCommitteeById(committeeId);
        List contentList = handlerContent(advice.getAdviceContent());
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
        return "content/adviceContent";
    }

    /**
     * 删除指定id号的提案
     *
     * @param id 提案id号
     */
    @SuppressWarnings("unused")
    @GetMapping("/{adviceId}/deleteAdvice")
    public void deleteAdvice(@PathVariable("adviceId") Integer id) {
        adviceDao.deleteAdviceById(id);
    }

    /**
     * 展示通知管理界面
     *
     * @param model 通知信息
     * @return 转入eventBody.jsp
     */
    @RequestMapping("/showEventBody")
    public String showEventBody(Model model) {
        List<Event> eventList = eventDao.queryEventList();
        model.addAttribute("eventList", eventList);
        model.addAttribute("sdf", sdf);
        return "body/eventBody";
    }

    /**
     * 删除通知
     *
     * @param id 通知id号
     */
    @GetMapping("/{eventId}/deleteEvent")
    public void deleteEvent(@PathVariable("eventId") Integer id) {
        eventDao.deleteEvent(id);
    }

    /**
     * 新增通知
     *
     * @param title   通知标题
     * @param content 通知内容
     */
    @PostMapping("/addEvent")
    public void addEvent(@RequestParam("title") String title,
                         @RequestParam("content") String content) {
        eventDao.insertEvent(title, content);
    }

    /**
     * 通知内容页面
     *
     * @param id    通知id号
     * @param model 通知内容信息
     * @return eventContent.jsp
     */
    @GetMapping("/{eventId}/eventContent")
    public String eventContent(@PathVariable("eventId") Integer id, Model model) {
        Event event = eventDao.queryEventById(id);
        List contentList = handlerContent(event.getEventContent());
        model.addAttribute("event", event);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/eventContent";
    }

    /**
     * 展示会议管理界面
     *
     * @param model 保存会议信息
     * @return 转入meetingBody.jsp
     */
    @RequestMapping("/showMeetingBody")
    public String showMeetingBody(Model model) {
        List<Meeting> meetingList = meetingDao.queryMeetingList();
        model.addAttribute("meetingList", meetingList);
        model.addAttribute("sdf", sdf);
        return "body/meetingBody";
    }

    /**
     * 新增会议信息
     *
     * @param title   会议标题
     * @param content 会议内容
     */
    @PostMapping("/addMeeting")
    public void addMeeting(@RequestParam("title") String title,
                           @RequestParam("content") String content) {
        meetingDao.insertMeeting(title, content);
    }

    /**
     * 删除会议信息
     *
     * @param id 会议id号
     */
    @GetMapping("/{meetingId}/deleteMeeting")
    public void deleteMeeting(@PathVariable("meetingId") Integer id) {
        meetingDao.deleteMeeting(id);
    }

    /**
     * 进入会议内容界面
     *
     * @param id    会议id号
     * @param model 会议内容信息
     * @return 进入meetingContent.jsp
     */
    @RequestMapping("/{meetingId}/meetingContent")
    public String meetingContent(@PathVariable("meetingId") Integer id, Model model) {
        Meeting meeting = meetingDao.queryMeetingById(id);
        List contentList = handlerContent(meeting.getMeetingContent());
        model.addAttribute("meeting", meeting);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/meetingContent";
    }

    /**
     * 展示新闻管理界面
     *
     * @param model 新闻信息
     * @return 进入showNewsBody.jsp
     */
    @RequestMapping("/showNewsBody")
    public String showNewsBody(Model model) {
        List<News> newsList = newsDao.queryNewsList();
        model.addAttribute("newsList", newsList);
        model.addAttribute("sdf", sdf);
        return "body/newsBody";
    }

    /**
     * 删除新闻
     *
     * @param id 新闻id号
     */
    @GetMapping("/{newsId}/deleteNews")
    public void deleteNews(@PathVariable("newsId") Integer id) {
        newsDao.deleteNews(id);
    }

    /**
     * 新增新闻
     *
     * @param title   新闻标题
     * @param content 新闻内容
     */
    @PostMapping("/addNews")
    public void addNews(@RequestParam("title") String title,
                        @RequestParam("content") String content) {
        newsDao.insertNews(title, content);
    }

    /**
     * 进入新闻内容界面
     *
     * @param id    新闻id号
     * @param model 新闻内容信息
     * @return 转入newsContent.jsp
     */
    @RequestMapping("/{newsId}/newsContent")
    public String newsContent(@PathVariable("newsId") Integer id, Model model) {
        News news = newsDao.queryNewsById(id);
        List contentList = handlerContent(news.getNewsContent());
        model.addAttribute("news", news);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/newsContent";
    }

    /**
     * 展示回复管理界面
     *
     * @param model 回复信息
     * @return 转入replyBody.jsp
     */
    @RequestMapping("/showReplyBody")
    public String showReplyBody(Model model) {
        List<Reply> replyList = replyDao.queryReplyList();
        model.addAttribute("replyList", replyList);
        model.addAttribute("sdf", sdf);
        return "body/replyBody";
    }

    /**
     * 回复内容界面
     *
     * @param id    回复id
     * @param model 回复信息
     * @return 转入replyContent.jsp
     */
    @RequestMapping("/{replyId}/replyContent")
    public String replyContent(@PathVariable("replyId") Integer id, Model model) {
        Reply reply = replyDao.queryReplyById(id);
        Advice advice = adviceDao.queryAdviceById(reply.getAdviceId());
        List contentList = handlerContent(reply.getReplyContent());
        model.addAttribute("reply", reply);
        model.addAttribute("advice", advice);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/replyContent";
    }

    /**
     * 删除回复
     *
     * @param id 回复id号
     */
    @GetMapping("/{replyId}/deleteReply")
    public void deleteReply(@PathVariable("replyId") Integer id) {
        replyDao.deleteReply(id);
    }

    @RequestMapping("/showOrganizationBody")
    public String showOrganizationBody(Model model) {
        List<Organization> organizationList = organizationDao.queryList();
        model.addAttribute("organizationList", organizationList);
        model.addAttribute("sdf", sdf);
        return "body/organizationBody";
    }

    @RequestMapping("/{organizationId}/organizationContent")
    public String organizationContent(@PathVariable("organizationId") Integer id, Model model) {
        Organization organization = organizationDao.queryById(id);
        List contentList = handlerContent(organization.getOrganizationContent());
        model.addAttribute("organization", organization);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/organizationContent";
    }

    @PostMapping("/addOrganization")
    public void addOrganization(@RequestParam("title") String name,
                                @RequestParam("content") String content) {
        organizationDao.insert(new Organization(name, content));
    }

    @GetMapping("/{organizationId}/deleteOrganization")
    public void deleteOrganization(@PathVariable("organizationId") Integer id) {
        organizationDao.delete(id);
    }

    @RequestMapping("/showQuestionBody")
    public String showQuestionBody(Model model) {
        List<Question> questionList = questionDao.queryList();
        model.addAttribute("questionList", questionList);
        model.addAttribute("sdf", sdf);
        return "body/questionBody";
    }

    @RequestMapping("/{questionId}/questionContent")
    public String questionContent(@PathVariable("questionId") Integer id, Model model) {
        Question question = questionDao.queryById(id);
        List contentList = handlerContent(question.getQuestionContent());
        model.addAttribute("question", question);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/questionContent";
    }

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestParam("title") String name,
                            @RequestParam("content") String content) {
        questionDao.insert(new Question(name, content));
    }

    @GetMapping("/{questionId}/deleteQuestion")
    public void deleteQuestion(@PathVariable("questionId") Integer id) {
        questionDao.delete(id);
    }

    @RequestMapping("/showRuleBody")
    public String showRuleBody(Model model) {
        List<Rule> ruleList = ruleDao.queryList();
        model.addAttribute("ruleList", ruleList);
        model.addAttribute("sdf", sdf);
        return "body/ruleBody";
    }

    @RequestMapping("/{ruleId}/ruleContent")
    public String ruleContent(@PathVariable("ruleId") Integer id, Model model) {
        Rule rule = ruleDao.queryById(id);
        List contentList = handlerContent(rule.getRuleContent());
        model.addAttribute("rule", rule);
        model.addAttribute("contentList", contentList);
        model.addAttribute("sdf", sdf);
        return "content/ruleContent";
    }

    @PostMapping("/addRule")
    public void addRule(@RequestParam("title") String name,
                        @RequestParam("content") String content) {
        ruleDao.insert(new Rule(name, content));
    }

    @GetMapping("/{ruleId}/deleteRule")
    public void deleteRule(@PathVariable("ruleId") Integer id) {
        ruleDao.delete(id);
    }


    /**
     * 对从数据库取出的内容信息做分行处理
     * 转化成行列表形式
     *
     * @param content 内容
     * @return 内容列表
     */
    private List handlerContent(String content) {
        String[] contents = {""};
        if (content != null && !("".equals(content))) {
            contents = content.split("\n");
        }
        return Arrays.asList(contents);
    }
}
