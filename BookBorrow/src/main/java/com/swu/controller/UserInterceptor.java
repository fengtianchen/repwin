package com.swu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.swu.model.User;

public class UserInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		String requestUri = request.getRequestURI();
//		for (String url : excludedUrls) {
//			if (requestUri.endsWith(url)) {
//				return true;
//			}
//		}
		User user = (User) request.getSession().getAttribute("user");
		if (user == null){
			response.sendRedirect(request.getContextPath()+"/login.html");
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
