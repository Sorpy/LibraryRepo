package application.dataaccess.dao.accountstatusdao;

import application.dataaccess.dao.common.BaseStorage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.data.entity.AccountStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountStatusData extends BaseStorage {
    public static List<AccountStatus> accountStatuses = new ArrayList<>();
    public static Map<Long, AccountStatus> accountStatusMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\application\\database\\AccountStatusJSON");

    static{
        try {
            accountStatuses = mapper.readValue(file1, new TypeReference<List<AccountStatus>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountStatusMap = accountStatuses
                .stream()
                .collect(Collectors.toMap(AccountStatus::getId, item -> item));
        file = file1;
        map = (HashMap) accountStatusMap;
    }
}
