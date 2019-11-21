package dataaccess.dao.usergroupdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.UserGroup;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserGroupData extends BaseStorage {
    public static List<UserGroup> userGroups = new ArrayList<>();
    public static Map<Long,UserGroup> userGroupMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\UserGroupJSON");

    static {
        try {
            userGroups = mapper.readValue(file1, new TypeReference<List<UserGroup>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        userGroupMap = userGroups
                .stream()
                .collect(Collectors.toMap(UserGroup::getId, item -> item));
        file = file1;
        map = (HashMap) userGroupMap;
    }
}
