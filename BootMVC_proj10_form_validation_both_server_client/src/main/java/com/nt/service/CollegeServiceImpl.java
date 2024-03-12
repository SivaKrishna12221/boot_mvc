package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.StudentInfo;
import com.nt.repo.CustomCollegeRepository;

@Service("service")
public class CollegeServiceImpl implements ICollegeServiceMgmt {
	@Autowired
	private CustomCollegeRepository collegeRepo;

	@Override
	public Iterable<StudentInfo> showStudentDetails() {
		Sort sort = Sort.by(Direction.ASC, "studentId");
		Iterable<StudentInfo> studDetails = collegeRepo.findAll(sort);
		System.out.println("****************88");
		studDetails.forEach(System.out::println);
		return studDetails;
	}

	@Override
	public String addNewStudent(StudentInfo sInfo) {
		StudentInfo stud = collegeRepo.save(sInfo);
		return "New Student is Added with id:" + stud.getStudentId();
	}

	@Override
	public Page<StudentInfo> displayRecordsByPagination(Pageable pageable) {

	 Page<StudentInfo> findAll = collegeRepo.findAll(pageable);
	 System.out.println("***************************8");
	 findAll.forEach(System.out::println);
	 return findAll;
	}

}
