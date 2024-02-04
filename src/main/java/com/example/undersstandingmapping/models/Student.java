package com.example.undersstandingmapping.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Student {

    @Id
    private Long id;

    private String name;
    private String psp;

    public Student(){

    }

//    @OneToMany(mappedBy = "student")
//    private List<Laptop> laptops;

}
