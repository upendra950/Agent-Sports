package com.example.AgentEsports.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.AgentEsports.Entity.LoginPage;
import com.example.AgentEsports.Entity.Role;
import com.example.AgentEsports.Repositories.LoginRepo;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepo loginRepo;

    @PutMapping("/register")
    public String userRegistration(@RequestBody  LoginPage userDetails){
        
        Optional<LoginPage> existingUser = loginRepo.findByUserName(userDetails.getUserName());
        if(userDetails.getEmail().strip()==" "|| userDetails.getUserName().strip()=="" || userDetails.getPassword().strip()==""|| userDetails.getMpin()==0||userDetails.getPhoneNumber()==0||userDetails.getState().strip()==""){
            return "enter valid details";
        }
        else{
        if (existingUser.isPresent()) {
            return "User already exists";
        }
        // Save the new user details to the database
        loginRepo.save(userDetails);
        // Return a response
        return "User registered successfully";}
    }
   
    @PutMapping("/password")
    public String updatePassword(@RequestParam("username") String  userName,@RequestParam("enter new password") String password ){
        Optional<LoginPage> details=loginRepo.findById(userName);
        if (details.isPresent()) {
            LoginPage user=details.get();
            if(user.getPassword().matches(password)){
                return "new password cannot be old one";
            }
            else{
                user.setPassword(password);
                loginRepo.save(user);
                return "password updated successfully";
            }   
    }
    else{
        return "user not found";
    }

    }
    @PutMapping("/role")
    public String updateRole(@RequestParam("enter admin username") String adminName,@RequestParam(" enter user to chanhge the role ") String userName,@RequestParam("role") Role role){
        Optional<LoginPage> adminDetails=loginRepo.findByUserName(adminName);
        Optional<LoginPage> userdetails=loginRepo.findById(userName);
        if (adminDetails.isPresent()){
            LoginPage admin=adminDetails.get();
            if(admin.getRole()==Role.ADMIN){
                if(userdetails.isPresent()){
                    LoginPage user=userdetails.get();
                    user.setRole(role);
                    loginRepo.save(user);
                    return "role updated successfully";     
                }
                else{
                    return "user not found ";
                }

            }
            else{
                return "only admins can change the role";
            }

        }
        else{
              return " admin not found ";
        }
    }


    
}
