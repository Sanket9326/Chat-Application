package com.ChatApplication.Project.Controller;

import com.ChatApplication.Project.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserManagementService userManagementService;

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestParam String username,@RequestParam String password,@RequestParam String email,@RequestParam String number) {
        return  userManagementService.createUser(username,password,email,number);
    }

    @GetMapping("login")
    public ResponseEntity<String> loginUser(@RequestParam String username,@RequestParam String password) {
        return userManagementService.loginUser(username,password);
    }

}
