package business.converter.accountclient;

import business.converter.BaseNamedResult;

import data.entity.AccountClientStatus;
import data.entity.User;

public class AccountClientResult  extends BaseNamedResult {
    private String firstName;
    private String secondName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String username;
    private String accountClientStatusName;
    private Long userId;
    private Long accountClientStatusId;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountClientStatusName() {
        return accountClientStatusName;
    }

    public void setAccountClientStatusName(String accountClientStatusName) {
        this.accountClientStatusName = accountClientStatusName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccountClientStatusId() {
        return accountClientStatusId;
    }

    public void setAccountClientStatusId(Long accountClientStatusId) {
        this.accountClientStatusId = accountClientStatusId;
    }

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


    @Override
    public String toString() {
        return "AccountClientResult{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", accountClientStatusName='" + accountClientStatusName + '\'' +
                ", userId=" + userId +
                ", accountClientStatusId=" + accountClientStatusId +
                '}';
    }
}
