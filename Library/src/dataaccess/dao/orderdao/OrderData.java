package dataaccess.dao.orderdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.Order;
import dataaccess.dao.accountdao.AccountData;
import dataaccess.dao.bookdao.BookData;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderData extends BaseStorage {
    public static List<Order> orders = new ArrayList<>();
    public static Map<Long,Order> orderMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\OrderJSON");

    static {
        try {
            orders = mapper.readValue(file1, new TypeReference<List<Order>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        orderMap = orders
                .stream()
                .collect(Collectors.toMap(Order::getId, item -> item));
        file = file1;
        map = (HashMap) orderMap;
    }
}
