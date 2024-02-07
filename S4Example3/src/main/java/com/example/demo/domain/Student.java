package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * Аннотация @ManyToMany:
     * <p>
     * fetch (Необязательно) Позволяет указать, нужна ли загрузка дочерних сущностей
     * (lazy - только при обращении, по умолчанию для связи ManyToMany)
     * <p>
     * cascade (Необязательно) Описывает, что должно происходить с зависимыми объектами,
     * если мы меняем их родительский (главный объект).
     * <p>
     * Аннотация @JoinTable:
     * <p>
     * name (Необязательно) Имя объединяемой таблицы
     * <p>
     * joinColumns (Необязательно) Столбцы внешнего ключа объединяемой таблицы,
     * которые ссылаются на основную (ведущую) таблицу объекта, владеющего ассоциацией
     * (т.е. содержащей аннотацию @JoinTable).
     * <p>
     * inverseJoinColumns (Необязательно) Столбцы внешнего ключа объединяемой таблицы,
     * которые ссылаются на основную таблицу объекта, которому не принадлежит ассоциация
     * (ведомая сторона ассоциации).
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

}
