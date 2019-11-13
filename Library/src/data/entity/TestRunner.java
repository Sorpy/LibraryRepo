package data.entity;

import business.converter.accountclient.AccountClientParam;
import business.converter.accountclient.AccountClientResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import dataaccess.dao.accountclientdao.AccountClientDao;
import dataaccess.dao.accountclientdao.AccountClientDaoImpl;
import presentation.service.accountclientservice.AccountClientService;
import presentation.service.accountclientservice.AccountClientServiceImpl;
import presentation.service.accountclientstatusservive.AccountClientStatusService;
import presentation.service.accountclientstatusservive.AccountClientStatusServiceImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestRunner {
    public void test() throws JsonProcessingException {

        AccountClientService accountClientService = new AccountClientServiceImpl();
        AccountClientStatusService accountClientStatusService = new AccountClientStatusServiceImpl();
        AccountClientDao accountClientDao = new AccountClientDaoImpl();

        AccountClientStatus accountClientStatus = new AccountClientStatus();
        UserStatus userStatus = new UserStatus();
        User user1 = new User("Name","Password",userStatus);
        AccountClientParam accountClientParam = new AccountClientParam();
        accountClientParam.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        accountClientParam.setSecondName("OtherName");
        accountClientParam.setLastName("ThirdName");
        accountClientParam.setPhone("asdasd");
        accountClientParam.setEmail("Email");
        accountClientParam.setCountry("Bulg");
        accountClientParam.setCity("Plovdiv");
        accountClientParam.setAddress("Some Adress");
        accountClientParam.setUnicode("sAA");
        accountClientParam.setName("AccountThing");
        accountClientParam.setDescription("Something");
        accountClientParam.setId((long) 4);
            //System.out.println(accountClientService.create(accountClientParam).getText());



        AccountClientParam accountClientParam2 = new AccountClientParam();

        accountClientParam2.setUserId((long) 3);
        accountClientParam2.setFirstName("Name");
        accountClientParam2.setSecondName("OtherName");
        accountClientParam2.setLastName("ThirdName");
        accountClientParam2.setPhone("asdasd");
        accountClientParam2.setEmail("Email");
        accountClientParam2.setCountry("Bulg");
        accountClientParam2.setCity("Plovdiv");
        accountClientParam2.setAddress("Some Adress");
        accountClientParam2.setUnicode("aAA");
        accountClientParam2.setName("AccountThing");
        accountClientParam2.setDescription("Something");
        accountClientParam2.setId((long) 5);
        accountClientParam2.setAccountClientStatusId((long)2);



        AccountClient accountClient11 = new AccountClient();
        accountClient11.setId((long)8);
        accountClient11.setCode("A5K");
        accountClient11.setName("asdasd");
        accountClient11.setAddress("asdasdasdasdas");
        accountClient11.setCountry("asdasd");
        accountClient11.setCity("asdadsasd");
        accountClient11.setEmail("asdasd");

        AccountClientResult accountClientResult = new AccountClientResult();


        AccountClientStatus accountClientStatus3 = new AccountClientStatus();
        UserStatus userStatus3 = new UserStatus();
        User user3 = new User("Name","Password",userStatus3);
        AccountClientParam accountClientParam3 = new AccountClientParam();
        accountClientParam3.setFirstName("Name");
        accountClientParam3.setSecondName("OtherName");
        accountClientParam3.setLastName("ThirdName");
        accountClientParam3.setPhone("asdasd");
        accountClientParam3.setEmail("Email");
        accountClientParam3.setCountry("Bulg");
        accountClientParam3.setCity("Plovdiv");
        accountClientParam3.setAddress("Some Adress");
        accountClientParam3.setUnicode("AKPaaaaas");
        accountClientParam3.setName("AccountThing");
        accountClientParam3.setDescription("Something");
        accountClientParam3.setId((long) 10);
        /*
        try {
            File file = new File("C:\\Users\\Lubo\\Desktop\\github\\internship\\Library\\src\\database\\AccountClientJSON");
            FileWriter fw = new FileWriter(file,true);
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fw);
            sequenceWriter.write(accountClient11);

        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        System.out.println(accountClientService.findByPK((long)2).getText());



    }
}
