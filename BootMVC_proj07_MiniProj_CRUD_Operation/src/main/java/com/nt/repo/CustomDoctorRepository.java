package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Doctor;

public interface CustomDoctorRepository extends PagingAndSortingRepository<Doctor, Integer> {

}
