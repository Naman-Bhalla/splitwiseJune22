package com.scaler.splitwisejune22.repositories;

import com.scaler.splitwisejune22.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findUsersByUsernameContainingAndPhoneNumberIs(String usernameContains,
//                                                                String phoneNumber);

    /**
     * If user has an id that is already there in the db, update that user with new value
     * Else it will create a new user
     * @param user
     * @return
     */
    User save(User user);
}

// find users whose username 0starts with u
// Project Building or Java Hibernate ORM

// Controller/ Service/ Repo
//  1. Makes it singleton
//  2. It allows you to inject the object of that class wherever you need