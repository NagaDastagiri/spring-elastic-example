package com.naga.elastic.elasticsearchexample.controller;

import com.naga.elastic.elasticsearchexample.model.Student;
import com.naga.elastic.elasticsearchexample.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo repo;

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student){
        return repo.save(student);
    }

    @GetMapping("/student/all")
    public List<Student> getStudents(){
       Iterator<Student> iterator = repo.findAll().iterator();
       List<Student> students = new ArrayList<>();
       while (iterator.hasNext()){
            students.add(iterator.next());
       }
       return  students;
    }


    @GetMapping("/student/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return repo.findById(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
        Optional<Student> std = repo.findById(id);
        if(std.isPresent()){
            Student s = std.get();
            s.setName(student.getName());
            return repo.save(s);
        }else{
            return  null;
        }
    }

    @DeleteMapping("/student/{id}")
    public Boolean delete(@PathVariable Integer id){
        repo.deleteById(id);
        System.out.println("Deleted");
        return true;
    }

}
