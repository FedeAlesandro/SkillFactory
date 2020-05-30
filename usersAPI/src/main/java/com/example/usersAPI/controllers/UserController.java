package com.example.usersAPI.controllers;

import com.example.usersAPI.dtos.UserDto;
import com.example.usersAPI.dtos.UserDtoNotValidated;
import com.example.usersAPI.exceptions.NotFoundException;
import com.example.usersAPI.models.User;
import com.example.usersAPI.projections.UserWithoutId;
import com.example.usersAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("")
    ResponseEntity<List<UserWithoutId>> getAll(){ //todo preguntar si así está bien.
        List<UserWithoutId>users = userService.getAll();
        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{dni}")
    ResponseEntity<UserDto> getByDni(@PathVariable(value = "dni")  String dni) throws NotFoundException {
        User userResponse = userService.getByDni(dni);
        return ResponseEntity.ok(new UserDto(userResponse));
    }

    @PostMapping("")        //todo no me anda el @Valid
    ResponseEntity<UserDto> add(@RequestBody @Valid User user){ //todo deberia ser un 201, un created, pero no se bien lo de URI que poner
        User userResponse = userService.add(user);
        return ResponseEntity.ok(new UserDto(userResponse));
    }

    @PutMapping("/{dni}")
    ResponseEntity<UserDto> update(@PathVariable(value = "dni") String dni, @RequestBody @Valid UserDto userDto){
        User user = userService.update(dni, userDto);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PatchMapping("/{dni}")
    ResponseEntity<UserDto> partialUpdate(@PathVariable(value = "dni") String dni, @RequestBody @Valid UserDtoNotValidated userDto){
        User user = userService.partialUpdate(dni, userDto);
        return ResponseEntity.ok(new UserDto(user));
    }
}
