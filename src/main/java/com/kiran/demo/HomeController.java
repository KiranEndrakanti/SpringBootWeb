package com.kiran.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@RequestMapping("home")
	public ModelAndView home(Alien alien) {
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		
		return mv;
		
	}
	
	
	@RequestMapping("home3")
	public ModelAndView home3(@RequestParam("name") String myName) {
	
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("home");
		
		return mv;
		
	}
	
	@RequestMapping("home1")
	public String home1(HttpServletRequest req) {
	
		HttpSession session = req.getSession();
		String name = req.getParameter("name");
		System.out.println("Home controller"+name);
		
		session.setAttribute("name", name);
		return "home";
		
	}
	
	@RequestMapping("home2")
	public String home2(String name,HttpSession session) {
	
		System.out.println("Home controller"+name);
		
		session.setAttribute("name", name);
		return "home";
		
	}
	
}
