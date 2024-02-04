package com.example.undersstandingmapping.controllers;

import com.example.undersstandingmapping.models.Student;
import com.example.undersstandingmapping.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    // Transactions 1 and 2 completely.

    @RequestMapping(path="/addStudent",method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE ,produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public Student addStudent(Student s) throws Exception{

        return  studentRepository.save(s);


    }


    @DeleteMapping("/students/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);

//        return ResponseEntity.noContent().build();
    }

//    filter Student by name
    @RequestMapping(method = RequestMethod.GET,value = "/getStudent")
    public Student getStudentByName(@RequestParam String name){
        return studentRepository.findByName(name);
    }

}
