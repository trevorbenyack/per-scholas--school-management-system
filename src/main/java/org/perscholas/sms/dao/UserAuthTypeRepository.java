package org.perscholas.sms.dao;

import org.perscholas.sms.entity.User;
import org.perscholas.sms.entity.UserAuthType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthTypeRepository extends JpaRepository<UserAuthType, Long> {
    public List<UserAuthType> findByUser(User user);
}
