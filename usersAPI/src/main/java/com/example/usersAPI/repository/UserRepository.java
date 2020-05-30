package com.example.usersAPI.repository;

import com.example.usersAPI.models.User;
import com.example.usersAPI.projections.UserWithoutId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByDni(String dni);

    @Query(value = "select name as name, last_name as lastname, dni as dni, country_code as countryCode from users;", nativeQuery = true)
    List<UserWithoutId> getAll();

}
