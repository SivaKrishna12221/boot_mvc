package com.nt.service;

import com.nt.entity.Employee;

public interface IEmpMgmtService {
	public Iterable<Employee> fetchAllEmployeeInfo();

	public String registerEmployeeDetails(Employee emp);

	public Employee fetchEmployeeDetailsByEmpno(Integer empno);

	public String saveEditedEmpDetails(Employee ename);

	public String deleteEmployeByEmpno(Integer empno);
}
