package org.duol.union.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Duolaimon
 * 17-11-22 下午1:59
 */
@Controller
public class Unauthorized {

    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }
}
