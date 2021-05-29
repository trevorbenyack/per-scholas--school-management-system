package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.StudentRepository;
import org.perscholas.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    // This annotation was put here to try to solve a LazyInitializationException
    // Didn't help... but gonna leave it for now.
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Student getStudentById(Long studentId) {
        return studentRepository.getById(studentId);
    }

    public List<Student> getAllStudents(){
        //logic
        return studentRepository.findAll();
    }



}
