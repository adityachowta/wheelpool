package models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 7/7/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupRequest {

    public String email;
    public String password;
    public String fullName;
    public String phone;
    public String gender;

    public SignupRequest() {
    }

    public SignupRequest(String email, String password, String fullName, String phone, String gender) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phone = phone;
        this.gender = gender;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
