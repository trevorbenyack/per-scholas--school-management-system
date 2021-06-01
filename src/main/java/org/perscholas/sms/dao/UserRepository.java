package org.perscholas.sms.dao;

import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);

}