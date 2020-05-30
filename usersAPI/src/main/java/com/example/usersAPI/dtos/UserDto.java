package com.example.usersAPI.dtos;

import com.example.usersAPI.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @Size(min = 7, max = 9)
    private String dni;

    public UserDto (User user){
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.dni = user.getDni();
    }
}
