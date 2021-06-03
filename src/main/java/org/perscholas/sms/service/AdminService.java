package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.perscholas.sms.dao.AdminRepository;
import org.perscholas.sms.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Log
public class AdminService {
    
    AdminRepository adminRepository;
    IdentityService identityService;

    @Transactional(propagation= Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
    public Admin getAdminById(Long adminId) {

        return adminRepository.getById(adminId);

    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }

    public boolean adminExistsById(Long adminId) {
        return adminRepository.existsById(adminId);
    }

    public Admin getCurrentAdmin() {

        log.info("inside getCurrentAdmin");

        if (adminExistsById(identityService.getCurrentUser().getId())) {
            log.info("current admin is " + getAdminById(identityService.getCurrentUser().getId()).toString());
            return getAdminById(identityService.getCurrentUser().getId());
        } else {
            log.info("No admin found");
            return null;
        }

    }
}
