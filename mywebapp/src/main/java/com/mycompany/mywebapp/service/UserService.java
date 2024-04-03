package com.mycompany.mywebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mywebapp.entity.User;
import com.mycompany.mywebapp.exception.UserNotFoundException;
import com.mycompany.mywebapp.repostory.UserRepository;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User getUserById(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);

        if (result.isPresent()) {
            return result.get();
        }

        throw new UserNotFoundException("Could not find any user with id:" + id);
    }

    public void deleteUser(Integer id) {
        User user = getUserById(id);
        repo.delete(user);
    }

}
