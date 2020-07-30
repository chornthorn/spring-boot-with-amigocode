package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("fakeStudentDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentId, Student student) {
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        return studentDao.insertNewStudent(studentId, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student updateStudent) {
        return studentDao.updateStudentById(studentId, updateStudent);
    }

    public int deleteStudentById(UUID studentId) {
        return studentDao.deleteStudentById(studentId);
    }

}
