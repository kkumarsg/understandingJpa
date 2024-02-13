package com.example.undersstandingmapping.controllers;

import com.example.undersstandingmapping.models.Student;
import com.example.undersstandingmapping.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    // to mark this class as a controller.
    // and return the output as json directly
    @RestController
    public class StudentController {

    // not a good idea to use repositories inside controllers

    // automatically wire an instance of repo to this class -> Autowired
    @Autowired
    private StudentRepository studentRepository;

    // I'  doing somehting

    // actual url to which you're serving the response
    @RequestMapping("/getStudents")
    public List<Student> getStudent(){

        return studentRepository.findAll();
    }

    //New api which allow client to create data of student via postman
    @RequestMapping(method = RequestMethod.PUT, value = "/create")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
            studentRepository.deleteById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/getStudent")
     public Student gerStudent(@RequestParam String name){
        return studentRepository.findByName(name);
    }

    // Transactions 1 and 2 completely.

}
