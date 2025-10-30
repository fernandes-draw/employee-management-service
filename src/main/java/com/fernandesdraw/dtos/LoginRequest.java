package com.fernandesdraw.dtos;

import lombok.Builder;

@Builder
public record LoginRequest(String email, String password) {

}
