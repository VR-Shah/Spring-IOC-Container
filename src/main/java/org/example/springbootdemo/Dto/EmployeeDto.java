package org.example.springbootdemo.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class EmployeeDto {

    private Long employeeId;

    @NotEmpty(message = "employeeName should not be empty")
    @Size(min=3,max=10,message="Number of EmployeeName should be in the range:[3,10]")
    private String employeeName;

    private Double salary;

    private Boolean isActive;

    private String designation;

    private LocalDate locDateOfJoining;

    @NotBlank(message = "Email of the employee can not be blank")
    @Email(message = "email should be a valida email")
    private String userName;

    @NotNull(message="password of the field can not be null")
    private String password;

    @NotNull(message = "age of the employee can not be blank")
    @Max(value=80, message = "Age of the Employee can not be greater than 80")
    @Min(value=30, message = "Age of the Employee can not be less than 30")
    private Integer age;

}
