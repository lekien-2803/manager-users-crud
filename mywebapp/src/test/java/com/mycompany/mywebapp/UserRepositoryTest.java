package com.mycompany.mywebapp;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.mycompany.mywebapp.entity.User;
import com.mycompany.mywebapp.repostory.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired private UserRepository repo;

    // Create
    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("admin@mail.com");
        user.setPassword("abc123");
        user.setFirstName("Kien");
        user.setLastName("Le");

        User user2 = User.builder()
        .email("admin2@mail.com")
        .password("abcabc")
        .firstName("Minh Khoi")
        .lastName("Le Tran")
        .build();

        User  savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    // Read
    @Test
    public void testShowAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGet(){
        Optional<User> optionalUser = repo.findById(1);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    // Update
    @Test
    public void testUpdate(){
        Optional<User> optinalUser = repo.findById(1);
        User user = optinalUser.get();
        user.setPassword("abcd1234");
        repo.save(user);

        User updatedUser = repo.findById(1).get();

        Assertions.assertThat(updatedUser.getPassword().equals("abcd1234"));
    }

    // Delete
    @Test
    public void testDelete(){
        repo.deleteById(1);
        Optional<User> optUser = repo.findById(1);
        Assertions.assertThat(optUser).isNotPresent();
    }
}
