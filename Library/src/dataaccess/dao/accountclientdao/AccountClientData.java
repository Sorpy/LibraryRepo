package dataaccess.dao.accountclientdao;

import data.entity.AccountClient;
import data.entity.AccountClientStatus;
import data.entity.User;
import data.entity.UserStatus;
import dataaccess.dao.accountclientstatusdao.AccountClientStatusData;
import dataaccess.dao.userdao.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountClientData {

    public static List<AccountClient> accountClients = new ArrayList<>();
    public static Map<Long,AccountClient> accountClientsMap;


    static {

        AccountClient accountClient1 = new AccountClient();
        accountClient1.setFirstName("Ivan");
        accountClient1.setSecondName("Petkov");
        accountClient1.setLastName("Draganov");
        accountClient1.setPhone("087887878787");
        accountClient1.setEmail("asdasd@abv.bg");
        accountClient1.setCity("Burgas");
        accountClient1.setCountry("Bulgaria");
        accountClient1.setAddress("SomeAddress");
        accountClient1.setAccountClientStatus(AccountClientStatusData.accountClientStatuses.get(0));
        accountClient1.setUser(UserData.users.get(0));
        accountClient1.setCode("AKK");
        accountClient1.setName("dataBase account1");
        accountClient1.setDescription("description of the account");
        accountClient1.setId((long) 1);


        UserStatus userStatus2 = new UserStatus();
        User user2 = new User("name2","password1",userStatus2);
        AccountClientStatus accountClientStatus2 = new AccountClientStatus();

        AccountClient accountClient2 = new AccountClient();
        accountClient2.setFirstName("Petar");
        accountClient2.setSecondName("Petkov");
        accountClient2.setLastName("Draganov");
        accountClient2.setPhone("087887878787");
        accountClient2.setEmail("asdasd@abv.bg");
        accountClient2.setCity("Burgas");
        accountClient2.setCountry("Bulgaria");
        accountClient2.setAddress("SomeAddress");
        accountClient2.setAccountClientStatus(accountClientStatus2);
        accountClient2.setUser(user2);
        accountClient2.setCode("AKK5");
        accountClient2.setName("dataBase account1");
        accountClient2.setDescription("description of the account");
        accountClient2.setId((long) 2);


        UserStatus userStatus3 = new UserStatus();
        User user3 = new User("name3","password1",userStatus3);
        AccountClientStatus accountClientStatus3 = new AccountClientStatus();

        AccountClient accountClient3 = new AccountClient();
        accountClient3.setFirstName("Ivan");
        accountClient3.setSecondName("Petkov");
        accountClient3.setLastName("Draganov");
        accountClient3.setPhone("087887878787");
        accountClient3.setEmail("asdasd@abv.bg");
        accountClient3.setCity("Burgas");
        accountClient3.setCountry("Bulgaria");
        accountClient3.setAddress("SomeAddress");
        accountClient3.setAccountClientStatus(accountClientStatus3);
        accountClient3.setUser(user3);
        accountClient3.setCode("AKK6");
        accountClient3.setName("dataBase account1");
        accountClient3.setDescription("description of the account");
        accountClient3.setId((long) 3);


        UserStatus userStatus4 = new UserStatus();
        User user4 = new User("name4","password1",userStatus4);
        AccountClientStatus accountClientStatus4 = new AccountClientStatus();

        AccountClient accountClient4 = new AccountClient();
        accountClient4.setFirstName("Todor");
        accountClient4.setSecondName("Petkov");
        accountClient4.setLastName("Draganov");
        accountClient4.setPhone("087887878787");
        accountClient4.setEmail("asdasd@abv.bg");
        accountClient4.setCity("Burgas");
        accountClient4.setCountry("Bulgaria");
        accountClient4.setAddress("SomeAddress");
        accountClient4.setAccountClientStatus(accountClientStatus4);
        accountClient4.setUser(user4);
        accountClient4.setCode("AKK8");
        accountClient4.setName("dataBase account1");
        accountClient4.setDescription("description of the account");
        accountClient4.setId((long) 4);


        UserStatus userStatus5 = new UserStatus();
        User user5 = new User("name5","password1",userStatus5);
        AccountClientStatus accountClientStatus5 = new AccountClientStatus();

        AccountClient accountClient5 = new AccountClient();
        accountClient5.setFirstName("Ivan");
        accountClient5.setSecondName("Petkov");
        accountClient5.setLastName("Draganov");
        accountClient5.setPhone("087887878787");
        accountClient5.setEmail("asdasd@abv.bg");
        accountClient5.setCity("Burgas");
        accountClient5.setCountry("Bulgaria");
        accountClient5.setAddress("SomeAddress");
        accountClient5.setAccountClientStatus(accountClientStatus5);
        accountClient5.setUser(user5);
        accountClient5.setCode("AK5K");
        accountClient5.setName("dataBase account1");
        accountClient5.setDescription("description of the account");
        accountClient5.setId((long) 5);


        UserStatus userStatus6 = new UserStatus();
        User user6 = new User("name6","password1",userStatus6);
        AccountClientStatus accountClientStatus6 = new AccountClientStatus();

        AccountClient accountClient6 = new AccountClient();
        accountClient6.setFirstName("Pesho");
        accountClient6.setSecondName("Petkov");
        accountClient6.setLastName("Draganov");
        accountClient6.setPhone("087887878787");
        accountClient6.setEmail("asdasd@abv.bg");
        accountClient6.setCity("Burgas");
        accountClient6.setCountry("Bulgaria");
        accountClient6.setAddress("SomeAddress");
        accountClient6.setAccountClientStatus(accountClientStatus6);
        accountClient6.setUser(user6);
        accountClient6.setCode("AK55K");
        accountClient6.setName("dataBase account1");
        accountClient6.setDescription("description of the account");
        accountClient6.setId((long) 6);


        UserStatus userStatus7 = new UserStatus();
        User user7 = new User("name7","password1",userStatus7);
        AccountClientStatus accountClientStatus7 = new AccountClientStatus();

        AccountClient accountClient7 = new AccountClient();
        accountClient7.setFirstName("Imeto");
        accountClient7.setSecondName("Petkov");
        accountClient7.setLastName("Draganov");
        accountClient7.setPhone("087887878787");
        accountClient7.setEmail("asdasd@abv.bg");
        accountClient7.setCity("Burgas");
        accountClient7.setCountry("Bulgaria");
        accountClient7.setAddress("SomeAddress");
        accountClient7.setAccountClientStatus(accountClientStatus7);
        accountClient7.setUser(user7);
        accountClient7.setCode("AK7K");
        accountClient7.setName("dataBase account1");
        accountClient7.setDescription("description of the account");
        accountClient7.setId((long) 7);

        accountClients.add(accountClient1);
        accountClients.add(accountClient2);
        accountClients.add(accountClient3);
        accountClients.add(accountClient4);
        accountClients.add(accountClient5);
        accountClients.add(accountClient6);
        accountClients.add(accountClient7);

        accountClientsMap = accountClients
                .stream()
                .collect(Collectors.toMap(AccountClient::getId, item -> item));
    }
}
