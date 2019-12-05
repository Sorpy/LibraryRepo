package application.business.converter.book;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Book;
import application.dataaccess.dao.authordao.AuthorDao;
import application.dataaccess.dao.authordao.AuthorDaoImpl;
import application.dataaccess.dao.bookstatusdao.BookStatusDao;
import application.dataaccess.dao.bookstatusdao.BookStatusDaoImpl;
import application.dataaccess.dao.departmentdao.DepartmentDao;
import application.dataaccess.dao.departmentdao.DepartmentDaoImpl;
import application.dataaccess.dao.genredao.GenreDao;
import application.dataaccess.dao.genredao.GenreDaoImpl;
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
    public Book convert(BookParam param, Book oldEntity){
        Book entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())&& param.getUnicode().equals(oldEntity.getCode())){
                entity = oldEntity;
            }
            else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            entity = new Book();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param,entity);
        entity = convertSpecific(param,entity);
        return entity;
    }


    @Override
    public Book convertSpecific(BookParam param, Book entity) {
        entity.setBookStatus(bookStatusDao.find(param.getBookStatusId()));
        entity.setAuthor(authorDao.find(param.getAuthorId()));
        entity.setGenre(genreDao.find(param.getGenreId()));
        entity.setDepartment(departmentDao.find(param.getDepartmentId()));
        return entity;
    }
}
