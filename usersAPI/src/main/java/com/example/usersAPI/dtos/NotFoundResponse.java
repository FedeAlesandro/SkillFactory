package com.example.usersAPI.dtos;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class NotFoundResponse {

    private String message;

}
