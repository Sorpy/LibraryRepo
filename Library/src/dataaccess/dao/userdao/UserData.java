package dataaccess.dao.userdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.User;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserData extends BaseStorage {
    public static List<User> users = new ArrayList<>();
    public static Map<Long,User> userMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\UserJSON");

    static {
        try {
            users = mapper.readValue(file1, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        userMap = users
                .stream()
                .collect(Collectors.toMap(User::getId, item -> item));
        file = file1;
        map = (HashMap) userMap;
    }
}
