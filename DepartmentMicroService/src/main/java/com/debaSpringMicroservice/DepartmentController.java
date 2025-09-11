package com.debaSpringMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.httpserver.HttpServer;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentService deptservice;

    DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
	
	@PostMapping
	ResponseEntity<Department> createResourc(@RequestBody Department dept) {
		Department createDept = deptservice.saveDepartment(dept);
		return new ResponseEntity<>(createDept, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Department findDeptById(@PathVariable("id") Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

}
