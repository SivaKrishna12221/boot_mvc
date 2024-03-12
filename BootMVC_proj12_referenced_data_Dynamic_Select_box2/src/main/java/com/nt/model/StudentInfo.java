package com.nt.model;

import lombok.Data;

@Data
public class StudentInfo {

	private Integer sno;
	private String sname;
	private String country = " ";
	private String state = " ";
	private String district = " ";
	private String mandal = " ";

}
