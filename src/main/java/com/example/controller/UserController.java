package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.UserDao;
import com.example.model.UserInfo;

@Controller
public class UserController {
	
	@Autowired
	UserDao userdao;
	
	@RequestMapping("addUser")
	public String addUser(UserInfo userinfo) {
		
		userdao.save(userinfo);
		return "index";
	}
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		ModelAndView mav= new ModelAndView("showUser");
		UserInfo userinfo=userdao.findById(id).orElse(new UserInfo());
		mav.addObject("user",userinfo);
		return mav;
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(@RequestParam int id) {
		ModelAndView mav= new ModelAndView("updateUserInfo");
		UserInfo userinfo= userdao.findById(id).orElse(new UserInfo());
		userdao.deleteById(id);
		mav.addObject("user",userinfo);
		return mav;
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		ModelAndView mav= new ModelAndView("deleteUserInfo");
		UserInfo userinfo= userdao.findById(id).orElse(new UserInfo());
		userdao.deleteById(id);
		mav.addObject("user",userinfo);
		return mav;
	}
	
}
