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

    String userName;
    String email;
    String password;
    String city;
    String country;

}

/*
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String userName, String email, String password, String city, String country) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
    }

 /*   public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }*/
 /*   public void setEmail(String email) {
        if (email != null)
            this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public void setPassword(String password) {
        if (password != null)
            this.password = password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
*/



