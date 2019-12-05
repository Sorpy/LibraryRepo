package application.dataaccess.dao.departmentdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.data.entity.Department;
import application.dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentData extends BaseStorage {
    public static List<Department> departments = new ArrayList<>();
    public static Map<Long, Department> departmentMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\application\\database\\DepartmentJSON");

    static {
        try {
            departments = mapper.readValue(file1, new TypeReference<List<Department>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        departmentMap = departments
                .stream()
                .collect(Collectors.toMap(Department::getId, item -> item));
        file = file1;
        map = (HashMap) departmentMap;
    }
}