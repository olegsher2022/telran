package dto;

public class UserDTOWith {
    String name;
    String lastName;
    String email;
    String password;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    // --------------------------------------

    public UserDTOWith withName(String  name){
        this.name = name;
        return this;
    }

    public UserDTOWith withLastName(String  lastName){
        this.lastName = lastName;
        return this;
    }

    public UserDTOWith withEmail(String  email){
        this.email = email;
        return this;
    }
    public UserDTOWith withPassword(String  password){
        this.password = password;
        return this;
    }
}
