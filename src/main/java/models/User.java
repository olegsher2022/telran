package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class User {
  //  private String userName;
    String email;
    String password;
   // private String city;
  //  private String country;


/*
    public User(){}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


    public User(String email) {
        this.email = email;

    }

   public User(String userName, String email, String password, String country,String city) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.city = city;

    }

    public void setEmail(String email) {
        if(email != null)
            this.email = email;
    }
    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public void setPassword(String password) {
        if(password != null)
            this.password = password;
    }
    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }*/


}
