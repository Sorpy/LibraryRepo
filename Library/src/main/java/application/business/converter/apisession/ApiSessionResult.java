package application.business.converter.apisession;

import application.business.converter.basepersistent.BaseNamedResult;
import org.springframework.stereotype.Component;

@Component
public class ApiSessionResult extends BaseNamedResult {

    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
