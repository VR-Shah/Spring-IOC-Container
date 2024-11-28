package org.example.springbootdemo.service;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootdemo.Dto.EmployeeDto;
import org.example.springbootdemo.Entity.Employee;
import org.example.springbootdemo.Exception.CustomExceptionHanlderClass;
import org.example.springbootdemo.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee saveEmployee = modelMapper.map(employeeDto, Employee.class);
        return modelMapper.map(employeeRepository.save(saveEmployee), EmployeeDto.class);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {
//        Employee employee = employeeRepository.findById(id).orElse(null);
//        return Optional.ofNullable(modelMapper.map(employee, EmployeeDto.class));
          return employeeRepository
                  .findById(id).map(employee -> modelMapper.map(employee, EmployeeDto.class));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return Collections.singletonList(modelMapper.map(employeeRepository.findAll(), EmployeeDto.class));
    }

    @Override
    public boolean deleteEmployeeById(Long id) {
        isExistByEmployeeId(id);
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        isExistByEmployeeId(employeeId);
        Employee empData = modelMapper.map(employeeDto, Employee.class);
        empData.setEmployeeId(employeeId);
        Employee employee = employeeRepository.save(empData);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    boolean isExistByEmployeeId(Long employeeId) {
        boolean isExistById = employeeRepository.existsById(employeeId);
        if(!isExistById) { throw new CustomExceptionHanlderClass("Employee Not Found"); }
        return true;
    }

}
