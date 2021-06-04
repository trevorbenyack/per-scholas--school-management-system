package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.UserAuthTypeRepository;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.entity.UserAuthType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserAuthTypeService {

    UserAuthTypeRepository userAuthTypeRepository;

    public List<UserAuthType> getUserAuthTypeByUser(User user) {
        return userAuthTypeRepository.findByUser(user);
    }

}
