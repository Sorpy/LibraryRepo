package application.business.converter.apisession;

import application.business.converter.basepersistent.BaseNamedParam;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionParam extends BaseNamedParam {

    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
