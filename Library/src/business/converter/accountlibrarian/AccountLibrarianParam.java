package business.converter.accountlibrarian;

import business.converter.BaseNamedParam;
import business.converter.user.UserParam;
import data.entity.AccountLibrarianStatus;
import data.entity.User;

public class AccountLibrarianParam  extends BaseNamedParam {
    private String firstName;
    private String secondName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountLibrarianStatusId() {
        return accountLibrarianStatusId;
    }

    public void setAccountLibrarianStatusId(Long accountLibrarianStatusId) {
        this.accountLibrarianStatusId = accountLibrarianStatusId;
    }

    private Long userId;
    private Long accountLibrarianStatusId;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
