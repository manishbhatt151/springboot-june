package com.prolimner.springbootjune.service;

import com.prolimner.springbootjune.entity.Department;
import com.prolimner.springbootjune.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentCode("IT-01")
                .departmentId(1L)
                .departmentAddress("Patna")
                .departmentName("IT")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(Optional.ofNullable(department));

        if(department != null) {
            Mockito.when(departmentRepository.save(department)).thenReturn(department);
        }
    }

    @Test
    @DisplayName("Return department when a valid name passed")
    public void WhenValidDepartment_FetchDepartmentByName() {
        String departmentName = "IT";
        Department dept = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, dept.getDepartmentName());
        assertNotEquals("NA", dept.getDepartmentName());
    }

    @Test
    @DisplayName("Save department when called")
    public void WhenValidDepartmentSave_SaveDepartment() {
        Department department = Department.builder()
                .departmentCode("IT-01")
                .departmentId(1L)
                .departmentAddress("Patna")
                .departmentName("IT")
                .build();

        Department departmentActual = departmentService.saveDepartment(department);

        assertEquals(department, departmentActual);
    }
}