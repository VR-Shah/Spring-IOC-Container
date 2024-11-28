package org.example.springbootdemo.service;

import org.example.springbootdemo.Dto.EmployeeDto;
import java.util.*;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    Optional<EmployeeDto> getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    boolean deleteEmployeeById(Long id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId);

}
