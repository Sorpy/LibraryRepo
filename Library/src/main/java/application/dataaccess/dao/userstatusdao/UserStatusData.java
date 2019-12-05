package application.dataaccess.dao.userstatusdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.data.entity.UserStatus;
import application.dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserStatusData extends BaseStorage {
    public static List<UserStatus> userStatuses = new ArrayList<>();
    public static Map<Long,UserStatus> userStatusMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\application\\database\\UserStatusJSON");

    static {
        try {
            userStatuses = mapper.readValue(file1, new TypeReference<List<UserStatus>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        userStatusMap = userStatuses
                .stream()
                .collect(Collectors.toMap(UserStatus::getId, item -> item));
        file = file1;
        map = (HashMap) userStatusMap;
    }
}
