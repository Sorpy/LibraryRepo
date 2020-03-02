package application.business.converter.user;

import application.business.converter.basepersistent.BaseParam;
import application.business.converter.common.customannotation.Track;
import org.springframework.stereotype.Component;

@Component
public class UserParam extends BaseParam {
    private String username;
    private Long userStatusId;
    @Track(ignore =false,source = "password",destination = "password")
    private String password;



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

    public Long getUserStatusId() {
        return userStatusId;
    }

    public void setUserStatusId(Long userStatusId) {
        this.userStatusId = userStatusId;
    }
}
