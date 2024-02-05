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
    @Autowired
    Student student;
    // not a good idea to use repositories inside controllers

    // automatically wire an instance of repo to this class -> Autowired
    @Autowired
    private StudentRepository studentRepository;

    // I'  doing somehting

    // actual url to which you're serving the response
    @RequestMapping("/getStudents") //  by default its a get method
    public List<Student> getStudent(){ //this get method , you can see in browser

        return studentRepository.findAll();
    }

    //create another API, which allows the client to create a student via postman
    @RequestMapping(method = RequestMethod.PUT,value = "/create") //apart from get api, rest all have to mention in request mapping
    public Student addStudent(@RequestBody Student student) // if you want to insert anything, its possible thru postman but not in browser
    {
        return studentRepository.save(student);
    }

    //create another API to delete the student
    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public void deleteStudent(@PathVariable Long id)
    {
        studentRepository.deleteById(id);
    }

    //create an api to get the student by their names
    @RequestMapping(method = RequestMethod.GET,value = "/getStudent")
    public Student getStudent(@RequestParam String name)
    {
        return studentRepository.findByName(name);
    }


    // Transactions 1 and 2 completely.

}
