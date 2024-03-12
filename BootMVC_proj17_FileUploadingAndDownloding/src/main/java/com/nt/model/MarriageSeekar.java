package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MarriageSeekar {

	private String name;
	private String gender = "female";
	private MultipartFile biodata;
	private MultipartFile photo;
}
