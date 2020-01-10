package application.data.entity;

import application.data.common.PersistentNamed;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class Account extends PersistentNamed {
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String phone;
    @Column
    private String email;
    @OneToOne(mappedBy = "")
    @JoinColumn(name = "accountStatus_id")
    private AccountStatus accountStatus;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
    @Id
    public Long getId() {
        return super.getId();
    }
}
