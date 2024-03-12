package com.nt.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service("service")
public class ServiceResolverImpl implements IresolverService {

	@Override
	public String getWishMessage() {

		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		if (hour < 12) {
			return "Good morning";
		} else if (hour < 16) {
			return "Good afternoon";

		} else if (hour < 18) {
			return "Goog evening";
		} else {
			return "Good night";
		}
	}
}
