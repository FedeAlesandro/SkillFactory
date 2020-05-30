package com.example.usersAPI.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataIntegrityViolationResponse {

    private String message;
}
