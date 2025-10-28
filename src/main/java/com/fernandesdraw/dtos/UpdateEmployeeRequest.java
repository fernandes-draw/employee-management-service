package com.fernandesdraw.dtos;

import com.fernandesdraw.entities.Employee;
import lombok.Builder;

@Builder
public record UpdateEmployeeRequest(String email, Employee employee) {
}
