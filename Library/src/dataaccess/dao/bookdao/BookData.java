package dataaccess.dao.bookdao;

import data.entity.Book;
import dataaccess.dao.authordao.AuthorData;
import dataaccess.dao.bookstatusdao.BookStatusData;
import dataaccess.dao.departmentdao.DepartmentData;
import dataaccess.dao.genredao.GenreData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookData {
    public static List<Book> books = new ArrayList<>();
    public static Map<Long,Book> bookMap;

    static {
        Book book1 = new Book();
        book1.setBookStatus(BookStatusData.bookStatuses.get(0));
        book1.setBookName("Name");
        book1.setDepartment(DepartmentData.departments.get(0));
        book1.setAuthor(AuthorData.authors.get(0));
        book1.setGenre(GenreData.genres.get(0));
        book1.setPrice(15.2);
        book1.setYear(1999);
        book1.setCode("AKPVs");
        book1.setId((long)55);
        book1.setDescription("asdasda");
        book1.setName("something");

        Book book2 = new Book();
        book2.setBookStatus(BookStatusData.bookStatuses.get(1));
        book2.setBookName("Name");
        book2.setDepartment(DepartmentData.departments.get(1));
        book2.setAuthor(AuthorData.authors.get(1));
        book2.setGenre(GenreData.genres.get(1));
        book2.setPrice(15.2);
        book2.setYear(1999);
        book2.setCode("A44KPs");
        book2.setId((long)5);
        book2.setDescription("asdasda");
        book2.setName("something");

        books.add(book1);
        books.add(book2);

    }
}
