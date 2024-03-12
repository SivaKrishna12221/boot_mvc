package com.nt.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateClass {
	public static void main(String[] args) {
		LocalDate ldt = LocalDate.now();
		System.out.println(ldt);// 2023-10-05
		LocalDateTime ldTime = LocalDateTime.now();
		System.out.println(ldTime);// 2023-10-05T11:14:52.330015500
	}
}
