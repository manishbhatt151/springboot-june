package com.prolimner.springbootjune.repository;

import com.prolimner.springbootjune.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Optional<Department> findByDepartmentName(String departmentName);

    // Docs: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
    public Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);

    // @Query("select d from Department d where UPPER(d.departmentAddress) = UPPER(?1)")
    @Query(value = "SELECT * FROM DEPARTMENT WHERE UPPER(DEPARTMENT_ADDRESS) = UPPER(?1)", nativeQuery = true)
    public Optional<Department> findByAddressCustomIgnoreCase(String departmentAddress);
}
