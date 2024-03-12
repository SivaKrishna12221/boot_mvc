package com.nt.interceptors;

import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeOutCheckInterceptor implements HandlerInterceptor {

	public TimeOutCheckInterceptor() {
		System.out.println("TimeOutCheckInterceptor.TimeOutCheckInterceptor()");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		if (hour < 9 && hour > 16) {
			RequestDispatcher rd = request.getRequestDispatcher("/error_page.jsp");
			rd.forward(request, response);
			return false;
		}
		return true;
	}

}
