package com.mycompany.mywebapp.repostory;

import org.springframework.data.repository.CrudRepository;

import com.mycompany.mywebapp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
