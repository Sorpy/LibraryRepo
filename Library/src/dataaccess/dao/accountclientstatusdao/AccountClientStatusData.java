package dataaccess.dao.accountclientstatusdao;

import data.entity.AccountClientStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountClientStatusData {

    public static List<AccountClientStatus> accountClientStatuses = new ArrayList<>();
    public static Map<Long,AccountClientStatus> accountClientStatusMap;

    static  {
       AccountClientStatus accountClientStatus1 = new AccountClientStatus();
        accountClientStatus1.setCode("AKP");
        accountClientStatus1.setDescription("This is an active client account");
        accountClientStatus1.setName("ActiveClientStatus");
        accountClientStatus1.setId((long) 1);

        AccountClientStatus accountClientStatus2 = new AccountClientStatus();
        accountClientStatus2.setCode("A5KP");
        accountClientStatus2.setDescription("This is an inactive client account");
        accountClientStatus2.setName("InactiveClientStatus");
        accountClientStatus2.setId((long) 2);

        AccountClientStatus accountClientStatus3 = new AccountClientStatus();
        accountClientStatus3.setCode("A2KP");
        accountClientStatus3.setDescription("This is an idle client account");
        accountClientStatus3.setName("IdleClientStatus");
        accountClientStatus3.setId((long) 3);

        AccountClientStatus accountClientStatus4 = new AccountClientStatus();
        accountClientStatus4.setCode("AK3P");
        accountClientStatus4.setDescription("somethingElse");
        accountClientStatus4.setName("SomethingElse");
        accountClientStatus4.setId((long) 4);

        accountClientStatuses.add(accountClientStatus1);
        accountClientStatuses.add(accountClientStatus2);
        accountClientStatuses.add(accountClientStatus3);
        accountClientStatuses.add(accountClientStatus4);

        accountClientStatusMap = accountClientStatuses
                .stream()
                .collect(Collectors.toMap(AccountClientStatus::getId, item -> item));
    }
}
