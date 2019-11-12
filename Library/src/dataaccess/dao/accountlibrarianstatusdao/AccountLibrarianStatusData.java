package dataaccess.dao.accountlibrarianstatusdao;

import data.entity.AccountLibrarianStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountLibrarianStatusData {
    public static List<AccountLibrarianStatus> accountLibrarianStatuses = new ArrayList<>();
    public static Map<Long,AccountLibrarianStatus> accountLibrarianStatusMap;

    static {
        AccountLibrarianStatus accountLibrarianStatus1 = new AccountLibrarianStatus();
        accountLibrarianStatus1.setCode("A233KP");
        accountLibrarianStatus1.setDescription("This is an active client account");
        accountLibrarianStatus1.setName("ActiveClientStatus");
        accountLibrarianStatus1.setId((long) 1);

        AccountLibrarianStatus accountLibrarianStatus2 = new AccountLibrarianStatus();
        accountLibrarianStatus2.setCode("AKAAP");
        accountLibrarianStatus2.setDescription("This is an inactive client account");
        accountLibrarianStatus2.setName("InactiveClientStatus");
        accountLibrarianStatus2.setId((long) 2);

        accountLibrarianStatuses.add(accountLibrarianStatus1);
        accountLibrarianStatuses.add(accountLibrarianStatus2);

        accountLibrarianStatusMap = accountLibrarianStatuses
                .stream()
                .collect(Collectors.toMap(AccountLibrarianStatus::getId, item -> item));
    }
}
