package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repo.CustomEmployeeRepository;

@Service("service")
public class EmployeeMgmtServiceImpl implements IEmpMgmtService {
	@Autowired
	private CustomEmployeeRepository empRepo;

	@Override
	public Iterable<Employee> fetchAllEmployeeInfo() {
		Sort sort = Sort.by(Direction.ASC, "empno");
		Iterable<Employee> emps = empRepo.findAll(sort);
		return emps;

	}

	@Override
	public String registerEmployeeDetails(Employee emp) {
		Employee emp1 = empRepo.save(emp);
		return "Employee edited successfully with emp number:" + emp1.getEmpno();
	}

	@Override
	public Employee fetchEmployeeDetailsByEmpno(Integer empno) {
		Employee emp = empRepo.findById(empno).get();
		return emp;
	}

	@Override
	public String saveEditedEmpDetails(Employee emp) {
		Employee empInfo = empRepo.save(emp);
		return empInfo.getEmpno() + ":Id  details are edited successfully";
	}

	@Override
	public Page<Employee> fetchAllEmpsInfoByPagination(Pageable pageable) {

		return empRepo.findAll(pageable);
	}

}
