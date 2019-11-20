package dataaccess.dao.accountstatusdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.AccountStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountStatusData {
    public static List<AccountStatus> accountStatuses = new ArrayList<>();
    public static Map<Long, AccountStatus> accountStatusMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file = new File(".\\src\\database\\AccountStatusJSON");

    static {
        try {
            accountStatuses = mapper.readValue(file, new TypeReference<List<AccountStatus>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountStatusMap = accountStatuses
                .stream()
                .collect(Collectors.toMap(AccountStatus::getId, item -> item));

    }
}
