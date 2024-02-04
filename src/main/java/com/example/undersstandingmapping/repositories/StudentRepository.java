package com.example.undersstandingmapping.repositories;


import com.example.undersstandingmapping.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Mark this interface as repository
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByName(String name);
}
