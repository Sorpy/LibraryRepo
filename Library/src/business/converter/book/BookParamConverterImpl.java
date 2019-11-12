package business.converter.book;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Book;
import dataaccess.dao.authordao.AuthorDao;
import dataaccess.dao.authordao.AuthorDaoImpl;
import dataaccess.dao.bookstatusdao.BookStatusDao;
import dataaccess.dao.bookstatusdao.BookStatusDaoImpl;
import dataaccess.dao.departmentdao.DepartmentDao;
import dataaccess.dao.departmentdao.DepartmentDaoImpl;
import dataaccess.dao.genredao.GenreDao;
import dataaccess.dao.genredao.GenreDaoImpl;

public class BookParamConverterImpl extends BaseParamConverterImpl<BookParam,Book> implements BookParamConverter {
    private BookStatusDao bookStatusDao = new BookStatusDaoImpl();
    private AuthorDao authorDao= new AuthorDaoImpl();
    private GenreDao genreDao=new GenreDaoImpl();
    private DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public Book convert(BookParam param, Book oldEntity){
        Book entity = null;
        if(oldEntity!=null)
        {
            if(param.getId().equals(oldEntity.getId())&& param.getCode().equals(oldEntity.getCode())){
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
            entity.setCode(param.getCode());
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
