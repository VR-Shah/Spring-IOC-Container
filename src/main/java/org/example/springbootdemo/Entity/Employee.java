package org.example.springbootdemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String employeeName;

    private Double salary;

    private String designation;

    private Boolean isActive;

    private LocalDate dateOfJoining;

    private String userName;

    private String password;

    private Integer age;

}
