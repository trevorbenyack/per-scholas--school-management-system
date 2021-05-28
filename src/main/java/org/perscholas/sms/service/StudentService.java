package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.StudentRepository;
import org.perscholas.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    public Student getStudentById(Long studentId) {
        return studentRepository.getById(studentId);
    }

    public List<Student> getAllStudents(){
        //logic
        return studentRepository.findAll();
    }



}
