package application.dataaccess.dao.genredao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import application.data.entity.Genre;
import application.dataaccess.dao.common.BaseStorage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenreData extends BaseStorage {
    public static List<Genre> genres = new ArrayList<>();
    public static Map<Long,Genre> genreMap;
    private static ObjectMapper mapper = new ObjectMapper();
    private static File file1 = new File(".\\src\\main\\java\\application\\database\\GenreJSON");

    static {
        try {
            genres = mapper.readValue(file1, new TypeReference<List<Genre>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        genreMap = genres
                .stream()
                .collect(Collectors.toMap(Genre::getId, item -> item));
        file = file1;
        map = (HashMap) genreMap;
    }
}
