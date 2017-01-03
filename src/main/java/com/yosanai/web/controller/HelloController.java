package com.yosanai.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yosanai.web.HelloConfig;


import com.yosanai.web.model.Hello;

@RestController
public class HelloController {

	private final HelloConfig config;

	@Autowired
	public HelloController(HelloConfig config) {
		this.config = config;
	}

	@RequestMapping(value = "/api/helloREST/{msg}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Hello helloRESTGet(@PathVariable String msg) {
		Hello ret = new Hello();
		ret.setMsg(String.format("%s -> Hi there, %s", config.getMessage(), msg));
		return ret;
	}

	@RequestMapping(value = "/api/helloREST", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Hello helloRESTPost(@RequestBody Hello msg) {
		Hello ret = new Hello();
		ret.setMsg(String.format("%s -> Hi there, %s", config.getMessage(), msg.getMsg()));
		return ret;
	}

}
