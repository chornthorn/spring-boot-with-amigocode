package com.example.demo.dao;

import com.example.demo.models.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeStudentDao")
public class FakeStudentDaoImpl implements StudentDao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {

        this.database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        Student student1 = new Student(studentId,20,"Bong","Thorn","Spring Boot");
        database.put(studentId,student1);
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId,student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>( database.values());
    }

    @Override
    public int updateStudentById(UUID studentId, Student updateStudent) {
        database.put(studentId,updateStudent);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
