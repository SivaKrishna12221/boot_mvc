package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.StudentInfo;

public interface ICollegeServiceMgmt {
	public Iterable<StudentInfo> showStudentDetails();

	public String addNewStudent(StudentInfo sInfo);

	public Page<StudentInfo> displayRecordsByPagination(Pageable pageable);
}
