package com.thuchanhchuyensau.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thuchanhchuyensau.dto.MyUser;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
	
	  @RequestMapping(value = "/web/home", method = RequestMethod.GET)
	   public ModelAndView homePage() {
	      ModelAndView mav = new ModelAndView("web/home");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/web/login", method = RequestMethod.GET)
	   public ModelAndView loginPage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/web/register", method = RequestMethod.GET)
	   public ModelAndView RegisterPage() {
	      ModelAndView mav = new ModelAndView("register");
	      return mav;
	   }
	  
	  @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
		public ModelAndView pageEror() {
			return new ModelAndView("redirect:/web/login?accessDenied");
		}
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public ModelAndView logoutPage(HttpServletRequest request,HttpServletResponse response) {
		  Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		  
		  if(auth!=null) {
			  new SecurityContextLogoutHandler().logout(request, response, auth);
		  }
			return new ModelAndView("redirect:/web/home");
		}
}
