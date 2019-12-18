package application.business.converter.book;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Book;
import application.dataaccess.dao.authordao.AuthorDao;
import application.dataaccess.dao.bookstatusdao.BookStatusDao;
import application.dataaccess.dao.departmentdao.DepartmentDao;
import application.dataaccess.dao.genredao.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookParamConverterImpl extends BaseParamConverterImpl<BookParam,Book> implements BookParamConverter {
    @Autowired
    private BookStatusDao bookStatusDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private DepartmentDao departmentDao ;




    @Override
    public void convertSpecific(BookParam param, Book entity) {
        entity.setBookStatus(bookStatusDao.find(param.getBookStatusId()));
        entity.setAuthor(authorDao.find(param.getAuthorId()));
        entity.setGenre(genreDao.find(param.getGenreId()));
        entity.setDepartment(departmentDao.find(param.getDepartmentId()));
    }

    @Override
    public Book getEntity(BookParam param) {
        Book book = new Book();
        book.setId(param.getId());
        book.setCode(param.getCode());
        return book;
    }
}
