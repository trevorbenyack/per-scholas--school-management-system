package org.perscholas.sms.dao;

import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);


}