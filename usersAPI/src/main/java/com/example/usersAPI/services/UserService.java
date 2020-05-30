package com.example.usersAPI.services;

import com.example.usersAPI.configuration.MyConfiguration;
import com.example.usersAPI.dtos.UserDto;
import com.example.usersAPI.dtos.UserDtoNotValidated;
import com.example.usersAPI.exceptions.NotFoundException;
import com.example.usersAPI.models.User;
import com.example.usersAPI.projections.UserWithoutId;
import com.example.usersAPI.repository.UserRepository;
import com.example.usersAPI.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.usersAPI.utils.Constants.DNI_NOT_FOUND;

@Service
public class UserService {

    @Value("${country_code}")
    private String countryCode;

    @Autowired
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserWithoutId> getAll() {
        MyConfiguration.getLog();
        return userRepository.getAll();
    }

    public User getByDni(String dni){
        MyConfiguration.getLog();
        return userRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException(DNI_NOT_FOUND));
    }

    public User add(User user) {
        MyConfiguration.getLog();
        user.setCountryCode(countryCode);
        return userRepository.save(user);
    }

    public User update(String dni, UserDto userDto) {
        MyConfiguration.getLog();
        Integer id = getByDni(dni).getId();
        User user = User.fromUserDto(userDto);
        user.setId(id);

        return userRepository.save(user); //El save lo actualiza si ya existe ese id
    }

    public User partialUpdate(String dni, UserDtoNotValidated userDto) { //todo preguntar si está bien usar el userDto en vez de un userBody, porque tendrian los mismos atributos
        MyConfiguration.getLog();
        User user = getByDni(dni);

        Optional.ofNullable(userDto.getDni()).ifPresent(user::setDni);
        Optional.ofNullable(userDto.getName()).ifPresent(user::setName);
        Optional.ofNullable(userDto.getLastName()).ifPresent(user::setLastName);

        return userRepository.save(user); //El save lo actualiza si ya existe ese id
    }


}
