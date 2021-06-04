package org.perscholas.sms.dao;

import org.perscholas.sms.entity.UserType;
import org.perscholas.sms.entity.UserTypeTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}
