package com.example.demo.dao;

import com.example.demo.models.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    int insertNewStudent(UUID studentId, Student student);

    Student selectStudentById(UUID studentId);

    List<Student> selectAllStudents();

    int updateStudentById(UUID studentId, Student updateStudent);

    int deleteStudentById(UUID studentId);

}
