package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.StudentInfo;

public interface IStudentService {

	public Page<StudentInfo> fetchAllStudentInfo(Pageable pageable);
}
