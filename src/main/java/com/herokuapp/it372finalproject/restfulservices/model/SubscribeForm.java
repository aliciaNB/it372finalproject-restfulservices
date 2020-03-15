package com.herokuapp.it372finalproject.restfulservices.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SubscribeForm {


    @Size(min=2, max=40, message="Must be at least 2 - 40 letters")
    @NotEmpty(message="First Name Required*")
    private String fname;

    @Size(min=2, max=40, message="Must be at least 2 - 40 letters")
    @NotEmpty(message="Last Name Required*")
    private String lname;

    @Size(min=5, max=254, message="Must be at least 5 - 254 characters")
    @NotEmpty(message="Email Required*")
    @Email
    private String email;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
