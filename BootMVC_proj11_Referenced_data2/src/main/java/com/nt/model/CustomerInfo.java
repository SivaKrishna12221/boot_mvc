package com.nt.model;

import java.util.Set;

import lombok.Data;

@Data
public class CustomerInfo// modelClass
{
	private Integer custno;
	private String custName;
	private String country = "India";
	private Set<String> languagesKnown = Set.of("Telugu", "Hindi");
	private Set<String> things;
}
