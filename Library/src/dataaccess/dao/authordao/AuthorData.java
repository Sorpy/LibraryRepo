package dataaccess.dao.authordao;

import data.entity.Author;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthorData {
    public static List<Author> authors = new ArrayList<>();
    public static Map<Long,Author> authorMap;

    static {
        Author author1 = new Author();
        author1.setCode("AKPs");
        author1.setDescription("something");
        author1.setName("Author");
        author1.setAuthorName("Author Name 1");
        author1.setId((long) 1);

        Author author2 = new Author();
        author2.setAuthorName("Author Name 2");
        author2.setCode("AKPsdd");
        author2.setDescription("author author");
        author2.setName("autjor autroh");
        author2.setId((long) 2);

        authors.add(author1);
        authors.add(author2);

        authorMap = authors
                .stream()
                .collect(Collectors.toMap(Author::getId, item->item));
    }
}
