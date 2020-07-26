package com.example.demo.RestController;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.QuestionAnswerService;
import com.example.demo.Service.TruncateDatabaseService;
import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")

@CrossOrigin("http://localhost:4200")
@RequestMapping("/crack")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    private QuestionAnswerService questionService;
    @Autowired
    private TruncateDatabaseService truncateDs;

    @PostMapping(value = "/course")
    public Course subject(@RequestBody Course language)
    {
        return courseRepository.save(language);
    }

    @GetMapping(value= "/course")
    @CrossOrigin("http://localhost:4200")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getAllsubject()
    {
        return courseRepository.findAll();

    }

    @GetMapping(value="/courses")
    public ResponseEntity<List<String>> getAllCourses()
    {
        List<String> courses= courseRepository.findAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping(value="/courses1")
    public List<String> getAllCourses1()
    {
        return questionService.getAllCourses();
    }

    @GetMapping(value= "/course/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Course> topicsbyCourse(@PathVariable Long id)
    {
        return courseRepository.findById(id);
    }


    @GetMapping(value="/truncate")
    public String truncateTable() throws Exception
    {
        truncateDs.truncate();
        return "test";

    }



}

