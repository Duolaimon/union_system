package org.duol.union.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Duolaimon
 * 17-11-21 下午11:24
 */
@Controller
public class LoginController {

    private final String userParaName = "username";
    private final String passParaName = "password";


    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/login/auth")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String username = req.getParameter(userParaName);
        String password = req.getParameter(passParaName);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return "redirect:/admin/showAdviceBody";
    }


}
