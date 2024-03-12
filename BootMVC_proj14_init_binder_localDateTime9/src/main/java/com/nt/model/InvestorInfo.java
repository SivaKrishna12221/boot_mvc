package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class InvestorInfo {

	private Integer ino;
	private String name;
	private LocalDate dor;
	private LocalTime tor;
	private LocalDateTime exit;

}
