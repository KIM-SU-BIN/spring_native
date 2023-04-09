package com.sensemeka.tweaksense.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = { "/join" }, method = RequestMethod.GET)
    public String join(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("JoinController>join");

        return "/join";
    }

}
