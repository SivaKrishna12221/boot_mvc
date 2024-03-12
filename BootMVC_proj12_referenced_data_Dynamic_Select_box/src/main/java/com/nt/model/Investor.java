package com.nt.model;

import lombok.Data;

@Data
public class Investor {
	private Integer ino;
	private String name;
	private String country = "";
	private String state;

}
