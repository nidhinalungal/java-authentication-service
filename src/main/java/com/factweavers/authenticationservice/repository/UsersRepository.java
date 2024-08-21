package com.factweavers.authenticationservice.repository;

import com.factweavers.authenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.inject.Named;

@Named
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
