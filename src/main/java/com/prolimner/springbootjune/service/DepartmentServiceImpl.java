package com.prolimner.springbootjune.service;

import com.prolimner.springbootjune.entity.Department;
import com.prolimner.springbootjune.error.DepartmentNotFoundException;
import com.prolimner.springbootjune.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);
        // return department.orElseGet(() -> new Department(-1L, "", "", ""));

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department doesn't exist");
        }

        return department.get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Optional<Department> deptDB = departmentRepository.findById(departmentId);

        if(deptDB.isEmpty()) return new Department(-1L, "", "", "");

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.get().setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.get().setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.get().setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(deptDB.get());
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName).orElseGet(() -> new Department(-1L, "", "", ""));
    }

    @Override
    public Department fetchDepartmentByAddressIgnoreCase(String departmentAddress) {
        return departmentRepository.findByAddressCustomIgnoreCase(departmentAddress).orElseGet(() -> new Department(-1L, "", "", ""));
    }
}
