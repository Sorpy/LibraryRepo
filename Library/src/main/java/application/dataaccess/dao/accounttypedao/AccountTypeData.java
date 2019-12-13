package application.dataaccess.dao.accounttypedao;

import application.data.entity.AccountType;
import application.dataaccess.dao.common.BaseStorage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountTypeData extends BaseStorage {
    public static List<AccountType> accountTypes = new ArrayList<>();
    public static Map<Long, AccountType> accountTypeMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\application\\database\\AccountTypeJSON");

    static{
        try {
            accountTypes = mapper.readValue(file1, new TypeReference<List<AccountType>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        accountTypeMap = accountTypes
                .stream()
                .collect(Collectors.toMap(AccountType::getId, item -> item));
        file = file1;
        map = (HashMap) accountTypeMap;
    }
}
