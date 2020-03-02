package application.data.entity;

import application.data.common.PersistentNamed;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ApiSession extends PersistentNamed {

    @Column
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
