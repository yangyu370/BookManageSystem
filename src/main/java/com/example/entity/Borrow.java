package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="borrow")
public class Borrow {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bid",referencedColumnName = "id")
    Books book;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sid",referencedColumnName="id")
    Student student;
    @Column(name="time")
    Date time;
}
