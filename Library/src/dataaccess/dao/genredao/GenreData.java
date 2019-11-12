package dataaccess.dao.genredao;

import data.entity.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenreData {
    public static List<Genre> genres = new ArrayList<>();
    public static Map<Long,Genre> genreMap;

    static {

        Genre genre1 = new Genre();
        genre1.setCode("A22KPs");
        genre1.setDescription("This is an active client account");
        genre1.setName("ActiveClientStatus");
        genre1.setId((long) 1);

        Genre genre2 = new Genre();
        genre2.setCode("AK899Ps");
        genre2.setDescription("This is an inactive client account");
        genre2.setName("InactiveClientStatus");
        genre2.setId((long) 2);

        genres.add(genre2);
        genres.add(genre2);

        genreMap = genres
                .stream()
                .collect(Collectors.toMap(Genre::getId, item -> item));
    }
}
