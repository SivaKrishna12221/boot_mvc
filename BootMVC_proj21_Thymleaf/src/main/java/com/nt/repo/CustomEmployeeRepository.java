package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Employee;

public interface CustomEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
