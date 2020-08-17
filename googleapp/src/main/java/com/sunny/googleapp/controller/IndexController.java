package com.sunny.googleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sunny.googleapp.config.SentrySupport;

import io.sentry.Sentry;
//import io.sentry.SentryClient;

@Controller
public class IndexController {
	
	@Autowired
	private SentrySupport sentrySupport;
	
//	private static SentryClient sentry;
	
	
	@GetMapping({"","/"})
	public String index() {
		Sentry.init();
		return "index";
	}
	
	@GetMapping("/product")
	public String product() {
		sentrySupport.logSimpleMessage("product오류 -----");
		return "product";
	}
	
	@GetMapping("/user")
	public String user() {
		sentrySupport.logSimpleMessage("user오류 -----");
		return "user";
	}
}

