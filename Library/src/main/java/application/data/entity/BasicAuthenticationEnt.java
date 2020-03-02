package application.data.entity;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthenticationEnt {
    private String username;
    private String password;

    public BasicAuthenticationEnt(String requestHeader) {
        if (null != requestHeader) {
            String base64Credentials = requestHeader.substring("Basic".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            final String[] values = credentials.split(":", 2);

            if (values != null) {
                this.setUsername(values[0]);
                this.setPassword(values[1]);
            }
        }
    }


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
}
