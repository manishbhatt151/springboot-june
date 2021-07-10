package com.prolimner.springbootjune.service;

import com.prolimner.springbootjune.entity.Department;
import com.prolimner.springbootjune.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartment(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);

    public Department fetchDepartmentByAddressIgnoreCase(String departmentAddress);
}
