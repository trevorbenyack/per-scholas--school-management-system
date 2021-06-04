package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.UserTypeRepository;
import org.perscholas.sms.entity.UserType;
import org.perscholas.sms.entity.UserTypeTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserTypeService {

    UserTypeRepository userTypeRepository;

    public String getUserTypeString (Long userTypeId) {

        UserType userType = userTypeRepository.getById(userTypeId);

        return userType.getUserTypeTitle().toString();
    }
}
