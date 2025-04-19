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
    @Column(name="email")
    String email;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    public void setStudentInfo(String name, String email, String sex, Integer grade) {
        if (this.student == null) {
            this.student = new Student();
        }
        this.student.setName(name);
        this.student.setEmail(email);
        this.student.setSex(sex);
        this.student.setGrade(grade);
    }
}
