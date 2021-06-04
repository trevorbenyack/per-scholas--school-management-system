package org.perscholas.sms.dao;

import org.perscholas.sms.entity.Student;
import org.perscholas.sms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select u from User u join UserAuthType uat on u = uat.user where uat.userType.UserTypeId = 1L")
    public List<User> findAllStudents();
}