package application.presentation.service;

import application.business.processor.authentication.AuthenticationProcessor;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping("/menu")
public class AuthenticationServiceImpl {

    @Autowired
    private AuthenticationProcessor authenticationProcessor;

    @ApiOperation("login")
    @GetMapping("/login")
    @ResponseBody
    public String login() {

        try {
            String authToken= authenticationProcessor.login();
                return authToken;

        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND).getBody();
        }
    }


    @ApiOperation("logout")
    @DeleteMapping("/logout")
    public ResponseEntity<String> logout() {
        try {
            authenticationProcessor.logout();
            return new ResponseEntity<>("session Logout",HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
