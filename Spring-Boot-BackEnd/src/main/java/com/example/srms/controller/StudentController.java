package com.example.srms.controller;

import java.util.List;
import java.util.Optional;

import com.example.srms.model.Student;
import com.example.srms.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(student.getPassword());
            student.setPassword(encodedPassword);
            Student _student = studentRepository.save(
                    student);
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/students")
    public List<Student> getAllPost() {
        return studentRepository.findAll();

    }

    // @GetMapping("/posts/{id}")
    // public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
    // Optional<Post> post = postRepository.findById(id);

    // if (post.isPresent()) {
    // return new ResponseEntity<>(post.get(), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @PutMapping("/posts/{id}")
    // public ResponseEntity<Post> updatePost(@PathVariable("id") long id,
    // @RequestBody Post tutorial) {
    // Optional<Post> postData = postRepository.findById(id);
    // if (postData.isPresent()) {
    // Post _post = postData.get();
    // _post.setTitle(tutorial.getTitle());
    // _post.setDescription(tutorial.getDescription());
    // _post.setAuthor(tutorial.getAuthor());
    // _post.setPublished(tutorial.isPublished());
    // return new ResponseEntity<>(postRepository.save(_post), HttpStatus.OK);
    // } else {
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
    // }

    // @DeleteMapping("/posts/{id}")
    // public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
    // try {
    // postRepository.deleteById(id);
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @DeleteMapping("/posts")
    // public ResponseEntity<HttpStatus> deleteAllPosts() {
    // try {
    // postRepository.deleteAll();
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

    // @GetMapping("/posts/published")
    // public ResponseEntity<List<Post>> findByPublished() {
    // try {
    // List<Post> tutorials = postRepository.findByPublished(true);
    // if (tutorials.isEmpty()) {
    // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    // }
    // return new ResponseEntity<>(tutorials, HttpStatus.OK);
    // } catch (Exception e) {
    // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}