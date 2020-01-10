package application.data.entity;

import application.data.common.Persistent;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Component
@Entity
public class UserGroup extends Persistent {
    @OneToOne
    @JoinColumn(name = "userGroupStatus_id")
    private UserGroupStatus userGroupStatus;

    public UserGroupStatus getUserGroupStatus() {
        return userGroupStatus;
    }

    public void setUserGroupStatus(UserGroupStatus userGroupStatus) {
        this.userGroupStatus = userGroupStatus;
    }
    @Id
    public Long getId() {
        return super.getId();
    }
}
