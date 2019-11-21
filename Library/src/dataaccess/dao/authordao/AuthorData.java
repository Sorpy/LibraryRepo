package dataaccess.dao.authordao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.Author;
import dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthorData extends BaseStorage {
    public static List<Author> authors = new ArrayList<>();
    public static Map<Long, Author> authorMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\database\\AuthorJSON");

    static {
        try {
            authors = mapper.readValue(file1, new TypeReference<List<Author>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        authorMap = authors
                .stream()
                .collect(Collectors.toMap(Author::getId, item -> item));
        file = file1;
        map = (HashMap) authorMap;
    }
}
