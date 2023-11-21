package models;

public class UserWith {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserWith withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserWith withPassword(String password) {
        this.password = password;
        return this;
    }
}
