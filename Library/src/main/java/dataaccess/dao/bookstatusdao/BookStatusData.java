package dataaccess.dao.bookstatusdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.BookStatus;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookStatusData extends BaseStorage {

    public static List<BookStatus> bookStatuses = new ArrayList<>();
    public static Map<Long,BookStatus> bookStatusMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\database\\BookStatusJSON");

    static {
        try {
            bookStatuses = mapper.readValue(file1, new TypeReference<List<BookStatus>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookStatusMap = bookStatuses
                .stream()
                .collect(Collectors.toMap(BookStatus::getId, item -> item));
        file = file1;
        map = (HashMap) bookStatusMap;
    }
}
