package org.perscholas.sms.security;

import org.perscholas.sms.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthGroup extends JpaRepository<AuthGroup,Long> {
    List<AuthGroup> findByaEmail(String username);
}
