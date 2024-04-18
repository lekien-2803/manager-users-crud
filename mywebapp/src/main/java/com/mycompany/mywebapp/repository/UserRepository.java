package com.mycompany.mywebapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.mywebapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
