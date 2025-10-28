package com.fernandesdraw.controllers;

import com.fernandesdraw.dtos.CreateEmployeeRequest;
import com.fernandesdraw.dtos.UpdateEmployeeRequest;
import com.fernandesdraw.entities.Employee;
import com.fernandesdraw.exceptions.EmployeeDoesNotExistException;
import com.fernandesdraw.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(originPatterns = "http://localhost:5731")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/")
    public Employee postEmployee(@RequestBody CreateEmployeeRequest body) {
        return employeeService.createEmployee(body.firstName(), body.lastName(), body.password());
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.readAllEmployees();
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable("email") String email) {
        return employeeService.readEmployeeByEmail(email);
    }

    @PutMapping("/")
    public Employee putUpdatedEmployee(@RequestBody UpdateEmployeeRequest body) {
        return employeeService.updateEmployee(body.email(), body.employee());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity deleteEmployee(@PathVariable("email") String email) {
        employeeService.deleteEmployee(email);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler({EmployeeDoesNotExistException.class})
    public ResponseEntity<String> handleEmployeeDoesNotExist() {
        return ResponseEntity.status(400).body("Unable to handle request at this time");
    }


}





























