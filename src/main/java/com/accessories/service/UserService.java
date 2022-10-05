package com.accessories.service;

import com.accessories.model.Users;
import com.accessories.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String createUser(Users users) {
        userRepository.save(users);
        return "Sign up was successful";
    }

    public String verifyUser(Users users) {
        Users usersDetails = userRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
        if(isNull(usersDetails.getEmail()) || isNull(usersDetails.getPassword())) {
            return "Details entered are incorrect, please try again";
        }
        if(!users.getPassword().equals(usersDetails.getPassword())) {
            return "Password is incorrect";
        }
        return "login was successful";
    }

}
