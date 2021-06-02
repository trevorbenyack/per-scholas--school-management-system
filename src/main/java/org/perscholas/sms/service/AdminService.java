package org.perscholas.sms.service;

import lombok.AllArgsConstructor;
import org.perscholas.sms.dao.AdminRepository;
import org.perscholas.sms.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
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

        if (adminExistsById(identityService.getCurrentUser().getId())) {
            return getAdminById(identityService.getCurrentUser().getId());
        }
        return null;
    }
}
