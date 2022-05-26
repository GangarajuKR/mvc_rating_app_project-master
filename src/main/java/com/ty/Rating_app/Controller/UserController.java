package com.ty.Rating_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ty.Rating_app.Service.UserService;
import com.ty.Rating_app.dto.User;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("getUser")
	public ModelAndView getUser() {
		ModelAndView view = new ModelAndView();
		view.addObject("user", new User());
		view.setViewName("createuser.jsp");
		return view;
	}

	@RequestMapping("usersave")
	public ModelAndView saveUser(@ModelAttribute User user) {
		User struture = service.saveUser(user);
		ModelAndView view = new ModelAndView();
		view.addObject("user", struture);
		view.setViewName("login.jsp");
		return view;
	}
	
	@RequestMapping("userupadate")
	public ModelAndView updateUser(@ModelAttribute User user) {
		User struture = service.updateUser(user.getId(), user);
		ModelAndView view = new ModelAndView();
		view.addObject("user", struture);
		view.setViewName("listusers.jsp");
		return view;
	}
	
	@RequestMapping("userdelete")
	public ModelAndView deleteUser(@ModelAttribute User user) {
		User struture = service.deleteUser(user.getId());
		ModelAndView view = new ModelAndView();
		view.addObject("user", struture);
		view.setViewName("listusers.jsp");
		return view;
	}
	
	@RequestMapping("listusers")
	public ModelAndView listUsers() {
		List<User> u = service.listusers();
		ModelAndView view = new ModelAndView();
		view.addObject("users", u);
		view.setViewName("listusers.jsp");
		return view;
	}
	
	
}
