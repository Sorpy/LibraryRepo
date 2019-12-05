package application.data.entity;

import application.business.converter.account.AccountParam;
import application.business.converter.account.AccountResult;
import application.business.converter.accountstatus.AccountStatusParam;
import application.business.converter.user.UserParam;
import application.presentation.service.authorservice.AuthorService;
import application.presentation.service.bookservice.BookService;
import application.presentation.service.departmentservice.DepartmentService;
import application.presentation.service.genreservice.GenreService;
import application.presentation.service.usergroupservice.UserGroupService;
import application.presentation.service.usergroupstatusservice.UserGroupStatusService;
import application.presentation.service.userstatusservice.UserStatusService;
import application.presentation.service.usersusergroupservice.UsersUserGroupService;
import com.fasterxml.jackson.core.JsonProcessingException;
import application.dataaccess.dao.accountdao.AccountDao;
import application.dataaccess.dao.accountdao.AccountDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.presentation.service.accountservice.AccountService;
import application.presentation.service.accountstatusservive.AccountStatusService;
import application.presentation.service.accountstatusservive.AccountStatusServiceImpl;
import application.presentation.service.userservice.UserService;
import application.presentation.service.userservice.UserServiceImpl;
@Component
public class TestRunner {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountStatusService accountStatusService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserGroupService userGroupService;
    @Autowired
    private UserGroupStatusService userGroupStatusService;
    @Autowired
    private UserStatusService userStatusService;
    @Autowired
    private UsersUserGroupService usersUserGroupService;

    public void test() throws JsonProcessingException {

        AccountStatus accountStatus = new AccountStatus();
        UserStatus userStatus = new UserStatus();
        User user1 = new User("Name","Password",userStatus);
        AccountParam accountParam = new AccountParam();
        accountParam.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        accountParam.setSecondName("OtherName");
        accountParam.setLastName("ThirdName");
        accountParam.setPhone("asdasd");
        accountParam.setEmail("Email");
        accountParam.setCountry("Bulg");
        accountParam.setCity("Plovdiv");
        accountParam.setAddress("Some Adress");
        accountParam.setUnicode("sAA");
        accountParam.setName("AccountThing");
        accountParam.setDescription("Something");
        accountParam.setId((long) 4);
            //System.out.println(accountService.create(accountParam).getText());



        AccountParam accountParam2 = new AccountParam();

        accountParam2.setUserId((long) 2);
        accountParam2.setFirstName("Name");
        accountParam2.setSecondName("OtherName");
        accountParam2.setLastName("ThirdName");
        accountParam2.setPhone("asdasd");
        accountParam2.setEmail("Email");
        accountParam2.setCountry("Bulg");
        accountParam2.setCity("Plovdiv");
        accountParam2.setAddress("Some Adress");
        accountParam2.setUnicode("aAA");
        accountParam2.setName("AccountThing");
        accountParam2.setDescription("Something");
        accountParam2.setId((long) 11);
        accountParam2.setAccountClientStatusId((long)2);



        Account account11 = new Account();
        account11.setId((long)5);
        account11.setCode("A5K");
        account11.setName("asdasd");
        account11.setAddress("asdasdasdasdas");
        account11.setCountry("asdasd");
        account11.setCity("asdadsasd");
        account11.setEmail("asdasd");

        AccountResult accountClientResult = new AccountResult();


        AccountStatus accountStatus3 = new AccountStatus();
        UserStatus userStatus3 = new UserStatus();
        User user3 = new User("Name","Password",userStatus3);
        AccountParam accountParam3 = new AccountParam();
        accountParam3.setFirstName("Name");
        accountParam3.setSecondName("OtherName");
        accountParam3.setLastName("ThirdName");
        accountParam3.setPhone("asdasd");
        accountParam3.setEmail("Email");
        accountParam3.setCountry("Bulg");
        accountParam3.setCity("Plovdiv");
        accountParam3.setAddress("Some Adress");
        accountParam3.setUnicode("AKPaaaaas");
        accountParam3.setName("AccountThing");
        accountParam3.setDescription("Something");
        accountParam3.setId((long) 10);

        AccountStatusParam accountStatus1 = new AccountStatusParam();
        accountStatus1.setUnicode("AKP");
        accountStatus1.setDescription("This is an active client account");
        accountStatus1.setName("ActiveClientStatus");
        accountStatus1.setId((long) 1);

        AccountStatus accountStatus2 = new AccountStatus();
        accountStatus2.setCode("A5KP");
        accountStatus2.setDescription("This is an inactive client account");
        accountStatus2.setName("InactiveClientStatus");
        accountStatus2.setId((long) 2);


        AccountStatus accountStatus4 = new AccountStatus();
        accountStatus4.setCode("AK3P");
        accountStatus4.setDescription("somethingElse");
        accountStatus4.setName("SomethingElse");
        accountStatus4.setId((long) 4);

        UserParam usr = new UserParam();
        usr.setPassword("444");
        usr.setUsername("something");
        usr.setUserStatusId((long)1);
/*
        try {
            File file = new File(".\\src\\database\\AccountStatusJSON");
            FileWriter fw = new FileWriter(file,true);
            ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

            SequenceWriter sequenceWriter = mapper.writer().writeValuesAsArray(fw);
            sequenceWriter.write(accountStatus1);
            sequenceWriter.write(accountStatus2);
            sequenceWriter.write(accountStatus4);

            sequenceWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        //System.out.println(accountService.findByPK((long)2).getText());

        //System.out.println(accountStatusService.listAll().getText());

        System.out.println(accountStatusService.create(accountStatus1).getText());
        //System.out.println(accountService.deleteById((long)3));


        //System.out.println(accountService.update(accountParam2.getId(),accountParam2));
    }
}