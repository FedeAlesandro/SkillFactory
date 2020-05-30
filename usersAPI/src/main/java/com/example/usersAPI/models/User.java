package com.example.usersAPI.models;

import com.example.usersAPI.dtos.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @NumberFormat
    @Size(min = 7, max = 9)
    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "country_code")
    private String countryCode;

    public static User fromUserDto(UserDto userDto){
        return User.builder()
                .dni(userDto.getDni())
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .build();
    }
}
