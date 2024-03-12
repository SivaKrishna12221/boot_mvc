package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.DoctorInfo;

public interface CustomDoctorInfoRepository extends PagingAndSortingRepository<DoctorInfo, Integer> {

}
