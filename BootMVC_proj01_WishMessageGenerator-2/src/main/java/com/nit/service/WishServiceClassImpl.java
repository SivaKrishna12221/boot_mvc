package com.nit.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("service")
public class WishServiceClassImpl implements IWishService {

    @Override
    public String wishMessageGenerator() {
	LocalDateTime ldt = LocalDateTime.now();
	int hour = ldt.getHour();
	if (hour < 12)
	    return "good morning";
	else if (hour < 16)
	    return "good afternoon";
	else if (hour < 20)
	    return "good evening";
	else
	    return "good night";

    }

    @Override
    public LocalDateTime generateWishTime() {

	return LocalDateTime.now();
    }
}
