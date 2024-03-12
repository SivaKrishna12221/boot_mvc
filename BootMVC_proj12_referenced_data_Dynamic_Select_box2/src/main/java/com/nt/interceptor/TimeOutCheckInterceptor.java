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

		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		if (hour < 9 && hour > 18) {
			RequestDispatcher rd = request.getRequestDispatcher("/error_student_home.jsp");
			rd.forward(request, response);
			return false;
		}
		return true;
	}
}
