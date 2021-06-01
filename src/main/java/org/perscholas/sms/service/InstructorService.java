package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.InstructorRepository;
import org.perscholas.sms.entity.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InstructorService {

    InstructorRepository instructorRepository;

    // This annotation was put here to try to solve a LazyInitializationException
    // Didn't help... but gonna leave it for now.
    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getById(instructorId);
    }

    public List<Instructor> getAllInstructors(){
        return instructorRepository.findAll();
    }
    public boolean instructorExistsById(Long instructorId) {
        return instructorRepository.existsById(instructorId);
    }
    
}