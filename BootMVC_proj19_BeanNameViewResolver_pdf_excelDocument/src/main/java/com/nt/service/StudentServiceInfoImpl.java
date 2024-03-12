package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentInfo;
import com.nt.repo.CustomStudentInfoRepository;

@Service("service")
public class StudentServiceInfoImpl implements IStudentService {
	@Autowired
	private CustomStudentInfoRepository studRepo;

	@Override
	public Page<StudentInfo> fetchAllStudentInfo(Pageable pageable) {
		Page<StudentInfo> pageData = studRepo.findAll(pageable);
		return pageData;
	}
}
