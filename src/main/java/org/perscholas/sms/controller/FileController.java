package org.perscholas.sms.controller;

import lombok.AllArgsConstructor;
import org.perscholas.sms.entity.User;
import org.perscholas.sms.service.FileService;
import org.perscholas.sms.service.IdentityService;
import org.perscholas.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class FileController {

    FileService fileService;
    UserService userService;
    IdentityService identityService;

    @GetMapping("/uploadform")
    public String uploadForm(){
        return "uploadform";
    }

    @PostMapping("/upload-photo")
    public String uploadPhoto(
            @RequestParam("imageUrl") MultipartFile file,
            RedirectAttributes redirectAttributes){

        fileService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename());
        redirectAttributes.addFlashAttribute("filename", "file-uploads" + File.separator +file.getOriginalFilename());

        String filePath = "/file-uploads/" + file.getOriginalFilename();
        // String filePath = "this/should/be/our/path" + file.getOriginalFilename();
        User user = identityService.getCurrentUser();
        user.setImageUrl(filePath);
        userService.updateUser(user);

        return "redirect:/admin/profile";

    }
}
