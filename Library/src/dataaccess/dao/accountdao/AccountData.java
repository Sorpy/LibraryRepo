package dataaccess.dao.accountdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.Account;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountData extends BaseStorage {


    public static List<Account> accounts = new ArrayList<>();
    public static Map<Long,Account> accountMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\AccountJSON");

    static{
        try {
            accounts = mapper.readValue(file1, new TypeReference<List<Account>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountMap = accounts
                .stream()
                .collect(Collectors.toMap(Account::getId, item -> item));
        file = file1;
        map = (HashMap) accountMap;
    }

    /*
    static {

        Account accountClient1 = new Account();
        accountClient1.setFirstName("Ivan");
        accountClient1.setSecondName("Petkov");
        accountClient1.setLastName("Draganov");
        accountClient1.setPhone("087887878787");
        accountClient1.setEmail("asdasd@abv.bg");
        accountClient1.setCity("Burgas");
        accountClient1.setCountry("Bulgaria");
        accountClient1.setAddress("SomeAddress");
        accountClient1.setAccountStatus(AccountStatusData.accountStatuses.get(0));
        accountClient1.setUser(UserData.users.get(0));
        accountClient1.setUnicode("AKK");
        accountClient1.setName("dataBase account1");
        accountClient1.setDescription("description of the account");
        accountClient1.setId((long) 1);


        UserStatus userStatus2 = new UserStatus();
        User user2 = new User("name2","password1",userStatus2);
        AccountStatus accountClientStatus2 = new AccountStatus();

        Account accountClient2 = new Account();
        accountClient2.setFirstName("Petar");
        accountClient2.setSecondName("Petkov");
        accountClient2.setLastName("Draganov");
        accountClient2.setPhone("087887878787");
        accountClient2.setEmail("asdasd@abv.bg");
        accountClient2.setCity("Burgas");
        accountClient2.setCountry("Bulgaria");
        accountClient2.setAddress("SomeAddress");
        accountClient2.setAccountStatus(accountClientStatus2);
        accountClient2.setUser(user2);
        accountClient2.setUnicode("AKK5");
        accountClient2.setName("dataBase account1");
        accountClient2.setDescription("description of the account");
        accountClient2.setId((long) 2);


        UserStatus userStatus3 = new UserStatus();
        User user3 = new User("name3","password1",userStatus3);
        AccountStatus accountClientStatus3 = new AccountStatus();

        Account accountClient3 = new Account();
        accountClient3.setFirstName("Ivan");
        accountClient3.setSecondName("Petkov");
        accountClient3.setLastName("Draganov");
        accountClient3.setPhone("087887878787");
        accountClient3.setEmail("asdasd@abv.bg");
        accountClient3.setCity("Burgas");
        accountClient3.setCountry("Bulgaria");
        accountClient3.setAddress("SomeAddress");
        accountClient3.setAccountStatus(accountClientStatus3);
        accountClient3.setUser(user3);
        accountClient3.setUnicode("AKK6");
        accountClient3.setName("dataBase account1");
        accountClient3.setDescription("description of the account");
        accountClient3.setId((long) 3);


        UserStatus userStatus4 = new UserStatus();
        User user4 = new User("name4","password1",userStatus4);
        AccountStatus accountClientStatus4 = new AccountStatus();

        Account accountClient4 = new Account();
        accountClient4.setFirstName("Todor");
        accountClient4.setSecondName("Petkov");
        accountClient4.setLastName("Draganov");
        accountClient4.setPhone("087887878787");
        accountClient4.setEmail("asdasd@abv.bg");
        accountClient4.setCity("Burgas");
        accountClient4.setCountry("Bulgaria");
        accountClient4.setAddress("SomeAddress");
        accountClient4.setAccountStatus(accountClientStatus4);
        accountClient4.setUser(user4);
        accountClient4.setUnicode("AKK8");
        accountClient4.setName("dataBase account1");
        accountClient4.setDescription("description of the account");
        accountClient4.setId((long) 4);


        UserStatus userStatus5 = new UserStatus();
        User user5 = new User("name5","password1",userStatus5);
        AccountStatus accountClientStatus5 = new AccountStatus();

        Account accountClient5 = new Account();
        accountClient5.setFirstName("Ivan");
        accountClient5.setSecondName("Petkov");
        accountClient5.setLastName("Draganov");
        accountClient5.setPhone("087887878787");
        accountClient5.setEmail("asdasd@abv.bg");
        accountClient5.setCity("Burgas");
        accountClient5.setCountry("Bulgaria");
        accountClient5.setAddress("SomeAddress");
        accountClient5.setAccountStatus(accountClientStatus5);
        accountClient5.setUser(user5);
        accountClient5.setUnicode("AK5K");
        accountClient5.setName("dataBase account1");
        accountClient5.setDescription("description of the account");
        accountClient5.setId((long) 5);


        UserStatus userStatus6 = new UserStatus();
        User user6 = new User("name6","password1",userStatus6);
        AccountStatus accountClientStatus6 = new AccountStatus();

        Account accountClient6 = new Account();
        accountClient6.setFirstName("Pesho");
        accountClient6.setSecondName("Petkov");
        accountClient6.setLastName("Draganov");
        accountClient6.setPhone("087887878787");
        accountClient6.setEmail("asdasd@abv.bg");
        accountClient6.setCity("Burgas");
        accountClient6.setCountry("Bulgaria");
        accountClient6.setAddress("SomeAddress");
        accountClient6.setAccountStatus(accountClientStatus6);
        accountClient6.setUser(user6);
        accountClient6.setUnicode("AK55K");
        accountClient6.setName("dataBase account1");
        accountClient6.setDescription("description of the account");
        accountClient6.setId((long) 6);


        UserStatus userStatus7 = new UserStatus();
        User user7 = new User("name7","password1",userStatus7);
        AccountStatus accountClientStatus7 = new AccountStatus();

        Account accountClient7 = new Account();
        accountClient7.setFirstName("Imeto");
        accountClient7.setSecondName("Petkov");
        accountClient7.setLastName("Draganov");
        accountClient7.setPhone("087887878787");
        accountClient7.setEmail("asdasd@abv.bg");
        accountClient7.setCity("Burgas");
        accountClient7.setCountry("Bulgaria");
        accountClient7.setAddress("SomeAddress");
        accountClient7.setAccountStatus(accountClientStatus7);
        accountClient7.setUser(user7);
        accountClient7.setUnicode("AK7K");
        accountClient7.setName("dataBase account1");
        accountClient7.setDescription("description of the account");
        accountClient7.setId((long) 7);

        accounts.add(accountClient1);
        accounts.add(accountClient2);
        accounts.add(accountClient3);
        accounts.add(accountClient4);
        accounts.add(accountClient5);
        accounts.add(accountClient6);
        accounts.add(accountClient7);


    }
    */
}
