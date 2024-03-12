package com.nt.interceptor;

import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeOutCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeOutCheckInterceptor.preHandle()");

		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		if (hour > 12 && hour < 16) {
			RequestDispatcher rd = request.getRequestDispatcher("/error_investor.jsp");
			rd.forward(request, response);
			return false;

		} else {
			return true;
		}
	}

}
