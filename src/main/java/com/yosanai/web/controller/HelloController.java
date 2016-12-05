package com.yosanai.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yosanai.web.model.Hello;

@Controller
public class HelloController {

	@RequestMapping(value = "/")
	public ModelAndView home(Locale locale, Model model) {
		return new ModelAndView("index.html");
	}

	@RequestMapping(value = "/api/helloREST/{msg}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Hello helloRESTGet(@PathVariable String msg) {
		Hello ret = new Hello();
		ret.setMsg(String.format("Hi there, %s", msg));
		return ret;
	}

	@RequestMapping(value = "/api/helloREST", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Hello helloRESTPost(@RequestBody Hello msg) {
		Hello ret = new Hello();
		ret.setMsg(String.format("Hi there, %s", msg.getMsg()));
		return ret;
	}

}
