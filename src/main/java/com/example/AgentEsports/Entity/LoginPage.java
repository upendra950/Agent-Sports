package com.example.AgentEsports.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

@Entity
public class LoginPage {
    @Id
    @Column(name = "username")
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private Long phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private long mpin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false ,columnDefinition = "varchar(10) DEFAULT 'USER'")
    private Role role;


    
    public LoginPage() {
    }

    
    public LoginPage(String userName, String password, String state, Long phoneNumber, String email, long mpin, Role role) {
        this.userName = userName;
        this.password = password;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mpin = mpin;
        this.role = role;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getMpin() {
        return mpin;
    }
    public void setMpin(long mpin) {
        this.mpin = mpin;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    

    

}

