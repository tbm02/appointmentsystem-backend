package com.argusoft.appointment.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.userdetails.UserDetailsService;

@Entity
@Table(name = "User")
public class User  {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "email")
    @Email
    @NotBlank(message = "Please provide email as it can not be empty")
    private String email;


    @Column(name = "password")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must contain atleast one capital charchter, one small character, one digit and one special character and minimum length is 8")
    private String password;

    @Column(name = "contactNo")
    @Pattern(regexp = "([+][1-9]{2,3})?([2-9]{1}[0-9]{5}|[789]{1}[0-9]{9})", message = "Please Provide the valid Contact No")
    private String contactNo;


    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public User(int userId, String email, String password, String contactNo, Role role) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.contactNo = contactNo;
        this.role = role;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}