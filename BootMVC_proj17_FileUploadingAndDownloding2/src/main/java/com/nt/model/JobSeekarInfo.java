package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JobSeekarInfo {

	private String name;
	private String gender;
	private MultipartFile photo;
	private MultipartFile resume;

}
