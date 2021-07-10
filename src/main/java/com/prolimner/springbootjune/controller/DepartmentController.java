package com.prolimner.springbootjune.controller;

import com.prolimner.springbootjune.entity.Department;
import com.prolimner.springbootjune.error.DepartmentNotFoundException;
import com.prolimner.springbootjune.service.DepartmentService;
import com.prolimner.springbootjune.service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Set;

@RestController
public class DepartmentController {

    private Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside the saveDepartment method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@Valid @PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

    @GetMapping("/departments/address/{name}")
    public Department fetchDepartmentByAddress(@PathVariable("name") String departmentAddress) {
        return departmentService.fetchDepartmentByAddressIgnoreCase(departmentAddress);
    }
}
