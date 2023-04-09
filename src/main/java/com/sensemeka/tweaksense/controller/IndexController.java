package com.sensemeka .tweaksense.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.sensemeka .tweaksense.AppGlobal;


@Controller
public class IndexController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		//logger.info("[TRACE] session : " + AppGlobal.sessionToMap(session).toString());
		
		if (session.getAttribute("account_id") == null) {
            session.invalidate();
            return "redirect:/login";
		}

		return "/index";
	}	
}
