package com.ty.Rating_app.Controller;

import java.beans.BeanProperty;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.Rating_app.Service.UserService;
import com.ty.Rating_app.dto.User;

@RestController
public class LoginController {

	@Autowired
	UserService service;

	@RequestMapping("validate")
	public ModelAndView validate() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("login.jsp");
		return view;
	}

	@RequestMapping("validation")
	public ModelAndView validateUser(@ModelAttribute User user) {
		User struture = service.validateUser(user.getUserName(), user.getPassword());
		ModelAndView view = new ModelAndView();
		if (struture.getRole().equals("admin")) {
			view.addObject("user", struture);
			view.setViewName("admin.jsp");
			return view;
		} else if (struture.getRole().equals("customer")) {
			view.addObject("user", struture);
			view.setViewName("customer");
			return view;
		}
		return null;
	}

}
