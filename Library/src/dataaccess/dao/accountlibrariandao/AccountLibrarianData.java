package dataaccess.dao.accountlibrariandao;

import data.entity.AccountLibrarian;
import dataaccess.dao.accountlibrarianstatusdao.AccountLibrarianStatusData;
import dataaccess.dao.userdao.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountLibrarianData {

    public static List<AccountLibrarian> accountLibrarians = new ArrayList<>();
    public static Map<Long,AccountLibrarian> accountLibrarianMap;

    static{
        AccountLibrarian accountLibrarian1 = new AccountLibrarian();
        accountLibrarian1.setFirstName("Ivan");
        accountLibrarian1.setSecondName("Petkov");
        accountLibrarian1.setLastName("Draganov");
        accountLibrarian1.setPhone("087887878787");
        accountLibrarian1.setEmail("asdasd@abv.bg");
        accountLibrarian1.setCity("Burgas");
        accountLibrarian1.setCountry("Bulgaria");
        accountLibrarian1.setAddress("SomeAddress");
        accountLibrarian1.setAccountLibrarianStatus(AccountLibrarianStatusData.accountLibrarianStatuses.get(0));
        accountLibrarian1.setUser(UserData.users.get(1));
        accountLibrarian1.setCode("AaaaKP");
        accountLibrarian1.setName("dataBase account1");
        accountLibrarian1.setDescription("description of the account");
        accountLibrarian1.setId((long) 5);
    }
}
