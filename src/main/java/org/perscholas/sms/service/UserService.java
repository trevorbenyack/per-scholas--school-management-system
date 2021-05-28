package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.UserRepository;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    // Find
    public User getUserbyId(Long id){
        return userRepository.getById(id);
    }
    public User getUserByEmail(String userEmail){
        return userRepository.findByEmail(userEmail);
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
