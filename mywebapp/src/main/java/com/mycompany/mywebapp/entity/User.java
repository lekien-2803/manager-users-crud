package com.mycompany.mywebapp.entity;

import ch.qos.logback.core.joran.event.BodyEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 15)
    private String password;

    @Column(nullable = false, length = 45, name = "first_name")
    private String firstName;

   @Column(nullable = false, length = 45, name = "last_name")
    private String lastName;

    
    // private Boolean isEnabled;


}
