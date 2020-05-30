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
public class UserDtoNotValidated {

    private String name;

    private String lastName;

    @Size(min = 7, max = 9)
    private String dni;

    public UserDtoNotValidated(User user){
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.dni = user.getDni();
    }
}
