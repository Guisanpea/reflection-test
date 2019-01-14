package models;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class UserForm {
    private String email;
    private String password;

    public UserForm() {

    }

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

    @Override
    public String toString() {
        return "Email: " + email + "\nPassword: " + password;
    }

}
