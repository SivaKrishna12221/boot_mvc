package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmpMgmtService {
	public Iterable<Employee> fetchAllEmployeeInfo();

	public String registerEmployeeDetails(Employee emp);

	public Employee fetchEmployeeDetailsByEmpno(Integer empno);

	public String saveEditedEmpDetails(Employee ename);

	public Page<Employee> fetchAllEmpsInfoByPagination(Pageable pageable);
}
