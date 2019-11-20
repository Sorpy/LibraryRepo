package data.entity;

import com.fasterxml.jackson.core.JsonProcessingException;

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
