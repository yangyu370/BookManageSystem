package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="account")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    int id;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;
    @Column(name="role")
    String role;
}
