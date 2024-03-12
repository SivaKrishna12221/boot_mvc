package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.StudentInfo;

public interface CustomCollegeRepository extends PagingAndSortingRepository<StudentInfo, Integer> {

}
