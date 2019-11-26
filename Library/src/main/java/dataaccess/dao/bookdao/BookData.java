package dataaccess.dao.bookdao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.Book;
import dataaccess.dao.authordao.AuthorData;
import dataaccess.dao.bookstatusdao.BookStatusData;
import dataaccess.dao.common.BaseStorage;
import dataaccess.dao.departmentdao.DepartmentData;
import dataaccess.dao.genredao.GenreData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookData extends BaseStorage {
    public static List<Book> books = new ArrayList<>();
    public static Map<Long,Book> bookMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\database\\BookJSON");

    static {
        try {
            books = mapper.readValue(file1, new TypeReference<List<Book>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookMap = books
                .stream()
                .collect(Collectors.toMap(Book::getId, item -> item));
        file = file1;
        map = (HashMap) bookMap;
    }
}
