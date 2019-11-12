package data.entity;

import business.converter.accountclient.AccountClientParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import presentation.service.accountclientservice.AccountClientServiceImpl;

public class Application {

    public static void main(String[] args) {
        TestRunner testRunner = new TestRunner();
        try {
            testRunner.test();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
