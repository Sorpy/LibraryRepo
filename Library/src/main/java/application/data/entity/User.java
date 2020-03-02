package application.data.entity;

import application.data.common.Persistent;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User extends Persistent {
    @Column(unique=true)
    private String username;
    @Column
    private String password;
    @OneToOne
    @JoinColumn(name = "userStatus_id")
    private UserStatus userStatus;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }
}
