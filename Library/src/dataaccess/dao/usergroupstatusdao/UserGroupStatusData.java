package dataaccess.dao.usergroupstatusdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.UserGroupStatus;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserGroupStatusData extends BaseStorage {
    public static List<UserGroupStatus> userGroupStatuses = new ArrayList<>();
    public static Map<Long,UserGroupStatus> userGroupStatusMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\UserGroupJSON");

    static {
        try {
            userGroupStatuses = mapper.readValue(file1, new TypeReference<List<UserGroupStatus>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        userGroupStatusMap = userGroupStatuses
                .stream()
                .collect(Collectors.toMap(UserGroupStatus::getId, item -> item));
        file = file1;
        map = (HashMap) userGroupStatusMap;
    }
}
