package org.example.springbootdemo.Controller;

import jakarta.validation.Valid;
import org.example.springbootdemo.Dto.EmployeeDto;
import org.example.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/getEmployeeById/{emplpyeeId}")
    public ResponseEntity<Optional<EmployeeDto>> getEmployeeById(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PutMapping("/updateEmployee/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long employeeId, @RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto, employeeId));
    }

    @DeleteMapping("deleteEmployee/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.noContent().build();
    }

}
