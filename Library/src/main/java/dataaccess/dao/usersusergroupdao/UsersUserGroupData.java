package dataaccess.dao.usersusergroupdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.UsersUserGroup;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsersUserGroupData extends BaseStorage {
    public static List<UsersUserGroup> usersUserGroups = new ArrayList<>();
    public static Map<Long,UsersUserGroup> usersUserGroupMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\database\\UsersUserGroupJSON");

    static {
        try {
            usersUserGroups = mapper.readValue(file1, new TypeReference<List<UsersUserGroup>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        usersUserGroupMap = usersUserGroups
                .stream()
                .collect(Collectors.toMap(UsersUserGroup::getId, item -> item));
        file = file1;
        map = (HashMap) usersUserGroupMap;
    }
}
