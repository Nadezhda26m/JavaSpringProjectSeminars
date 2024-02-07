package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    /**
     * mappedBy: Поле, которому принадлежит связь. Требуется, если связь не является однонаправленной.
     * В данном случае поле students связано с полем courses в таблице students
     */
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

}
