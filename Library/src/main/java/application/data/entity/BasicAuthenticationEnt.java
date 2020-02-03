package application.data.entity;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthenticationEnt {
    private String username;
    private String password;

    public BasicAuthenticationEnt(String requestHeader){
        String base64Str = requestHeader.replace("Basic","").trim();
        byte[] byteArray = Base64.getDecoder().decode(base64Str);
        String credentials = new String(byteArray, StandardCharsets.UTF_8);
        String[] splitCredentials = credentials.split(":");

        if (splitCredentials.length==2){
            setUsername(splitCredentials[0]);
            setPassword(splitCredentials[1]);
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
