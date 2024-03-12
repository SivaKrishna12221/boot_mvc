package com.nt.model;

import lombok.Data;

@Data
public class CustomerInfo {
	private Integer cno;
	private String custName;
	private String country = "India";
	private String[] languagesKnown = new String[] { "Telugu", "Hindi" };
	private String[] hobbies = new String[] { "watching movies", "playing cricket" };

}
