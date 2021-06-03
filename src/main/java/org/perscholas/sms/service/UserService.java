package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.UserRepository;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    UserRepository userRepository;
    InstructorService instructorService;

    // Find
    public User getUserbyId(Long id){
        return userRepository.getById(id);
    }

    public User getUserByEmail(String userEmail){
        return userRepository.findByEmail(userEmail).stream().findFirst().orElse(null);
    }

    // Save
    public User saveUser(User newUser){
        return userRepository.saveAndFlush(newUser);
    }


    // Update
    public User updateUser(User user) {
        return userRepository.saveAndFlush(user);
    }


}
