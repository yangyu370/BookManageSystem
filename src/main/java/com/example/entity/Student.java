package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="email")
    String email;
    @Column(name="sex")
    String sex;
    @Column(name="grade")
    int grade;
}
