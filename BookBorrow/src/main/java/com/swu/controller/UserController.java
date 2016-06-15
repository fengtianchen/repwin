package com.swu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swu.model.User;
import com.swu.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/register")
	public String userRegiser(User user, ModelMap model) {
		if (userService.register(user)) {
			model.addAttribute("regiserMessage", "注册成功！");
		} else {
			model.addAttribute("regiserMessage", "注册失败！");
		}
		return "login";
	}

	@RequestMapping("/userlogin")
	public String userLogin(User user, ModelMap model, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		User qu = userService.login(user);
		if (null != qu) {
			session.setAttribute("user", qu);
			return "index";
		} else {
			model.addAttribute("loginMessage", "账号或密码错误！");
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String userLogout(ModelMap model, HttpServletResponse response, HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "index";
	}
	
	@RequestMapping(value="/userisexist")
	public void isExist(String name, HttpServletResponse response){
		boolean isexist = userService.isexist(name);
		try {
			PrintWriter wt =  response.getWriter();
			wt.print(isexist);
			wt.flush();
			wt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
