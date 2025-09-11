package com.debaSpringMicroservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository deptrepository;
	
	public Department saveDepartment(Department dept) {
		return deptrepository.save(dept);
	}
	
	public Department findDeptById(Long departmentId) {
		return deptrepository.findById(departmentId).get();
	}

}
