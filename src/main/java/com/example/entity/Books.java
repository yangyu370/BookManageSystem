package com.example.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="Books")
public class Books {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    int id;
    @Column(name="title")
    String title;
    @Column(name="description")
    String desc;
    @Column(name="price")
    double price;
    @Column(name="status")
    String status;

}
