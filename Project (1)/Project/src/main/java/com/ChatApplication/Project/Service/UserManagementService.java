package com.ChatApplication.Project.Service;

import com.ChatApplication.Project.Models.User;
import com.ChatApplication.Project.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService {

    @Autowired
    UserDao userDao;

    public ResponseEntity<String> createUser(String username, String password, String email, String number) {
        try {
            if (!userDao.verifyUser(username).isEmpty()){
                return  new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
            }
           User user = new User();
           user.setUsername(username);
           user.setPassword(password);
           user.setEmail(email);
           user.setNumber(number);
           userDao.save(user);
           return new ResponseEntity<>("User created", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.OK);
        }
    }

    public ResponseEntity<String> loginUser(String username, String password) {
        try {
            List<User> user = userDao.loginUser(username,password);
            if(user.isEmpty()){
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>("User Verified", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.OK);
        }
    }

    public boolean verifyUser(String username) {
       List<User> user =  userDao.verifyUser(username);
       if(user.size()==0){
           return false;
       }
       return true;
    }

}
