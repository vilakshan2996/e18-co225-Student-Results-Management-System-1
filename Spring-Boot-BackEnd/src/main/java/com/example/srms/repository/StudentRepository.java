package com.example.srms.repository;

import java.util.List;

import com.example.srms.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

}