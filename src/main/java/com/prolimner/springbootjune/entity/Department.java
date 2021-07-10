package com.prolimner.springbootjune.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name")
    private String departmentName;
    private String departmentAddress;

    // Docs: https://www.baeldung.com/javax-validation
    @NotBlank(message = "Please provide Department Code")
    @Length(max = 5)
    private String departmentCode;
}
