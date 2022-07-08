package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="first_name")
    private String fname;
    @Column(name="last_name")
    private String lname;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
}
