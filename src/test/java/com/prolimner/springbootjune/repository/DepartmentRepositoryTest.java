package com.prolimner.springbootjune.repository;

import com.prolimner.springbootjune.entity.Department;
import com.prolimner.springbootjune.error.DepartmentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department dept = Department.builder()
                .departmentCode("ME-1")
                .departmentName("Mechanical Eng")
                .departmentAddress("Delhi")
                .build();

        entityManager.persist(dept);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Mechanical Eng", department.getDepartmentName());
    }
}