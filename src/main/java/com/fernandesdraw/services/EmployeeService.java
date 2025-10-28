package com.fernandesdraw.services;

import com.fernandesdraw.entities.Employee;
import com.fernandesdraw.exceptions.EmployeeDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<String, Employee> employees;

    public Employee createEmployee(String firstName, String lastName, String password) {
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@company.com";

        Employee employee = Employee.builder().firstName(firstName).lastName(lastName).email(email).password(password).build();

        employees.put(email, employee);

        return employee;
    }

    public List<Employee> readAllEmployees() {
        return employees.values().stream().toList();
    }

    public Employee readEmployeeByEmail(String email) {
        if (!employees.containsKey(email)) {
            throw new EmployeeDoesNotExistException();
        }

        return employees.get(email);
    }

    public Employee updateEmployee(String email, Employee updated) {
        if (!employees.containsKey(email)) {
            throw new EmployeeDoesNotExistException("Employee to updated does not exist");
        }

        Employee persisted;

        if (!email.equals(updated.getEmail())) {
            employees.remove(email);
            employees.put(updated.getEmail(), updated);
            persisted = employees.get((updated.getEmail()));
        } else {
            persisted = employees.replace(email, updated);
        }

        return persisted;
    }

    public void deleteEmployee(String email) {
        Employee deletedEmployee = employees.remove(email);

        if (deletedEmployee == null) throw new EmployeeDoesNotExistException("Employee to delete does not exist");
    }

    public void loadEmployeeData() {
        employees = new HashMap<>();

        employees.put("adminemployee@company.com", Employee.builder()
                .firstName("admin")
                .lastName("employee")
                .email("adminemployee@company.com")
                .password("pass")
                .build());

        employees.put("manageremployee@company.com", Employee.builder()
                .firstName("manager")
                .lastName("employee")
                .email("manageremployee@company.com")
                .password("pass")
                .build());

        employees.put("employeeone@company.com", Employee.builder()
                .firstName("employee")
                .lastName("one")
                .email("employeeone@company.com")
                .password("pass")
                .build());
    }
}






















