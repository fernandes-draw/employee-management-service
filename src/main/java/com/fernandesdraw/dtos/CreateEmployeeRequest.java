package com.fernandesdraw.dtos;

import lombok.Builder;

@Builder
public record CreateEmployeeRequest(String firstName, String lastName, String password) {

}
