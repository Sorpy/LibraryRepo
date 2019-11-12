package business.processor.bookstatusprocessor;

import business.converter.bookstatus.*;
import data.entity.BookStatus;
import dataaccess.dao.bookstatusdao.BookStatusDao;
import dataaccess.dao.bookstatusdao.BookStatusDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class BookStatusProcessorImpl implements BookStatusProcessor{
    private BookStatusDao bookStatusDao = new BookStatusDaoImpl();
    private BookStatusParamConverter bookStatusParamConverter = new BookStatusParamConverterImpl();
    private BookStatusResultConverter bookStatusResultConverter = new BookStatusResultConverterImpl();


    @Override
    public BookStatusResult create(BookStatusParam param) {
        return bookStatusResultConverter.convert
                (bookStatusDao.save
                        (bookStatusParamConverter.convert(param,null)));
    }

    @Override
    public List<BookStatusResult> create(List<BookStatusParam> param) {
        List<BookStatus> bookStatuses = new ArrayList<>();
        List<BookStatusResult> bookStatusResults = new ArrayList<>();

        param.forEach
                (bookStatus -> bookStatuses.add
                (bookStatusParamConverter.convert(bookStatus,null)));
        bookStatusDao.save(bookStatuses);
        bookStatuses.forEach
                (bookStatus -> bookStatusResults.add
                        (bookStatusResultConverter.convert(bookStatus)));

        return bookStatusResults;
    }

    @Override
    public void update(Long id, BookStatusParam param) {
        BookStatus oldEntity = bookStatusDao.find(id);
        if (oldEntity!=null){
            bookStatusDao.update(bookStatusParamConverter.convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<BookStatusParam> param) {

    }

    @Override
    public void delete(Long id) {
        bookStatusDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        bookStatusDao.delete(idList);
    }

    @Override
    public BookStatusResult find(Long id) {
        return bookStatusResultConverter.convert(bookStatusDao.find(id));
    }

    @Override
    public List<BookStatusResult> find() {
        List<BookStatusResult> bookStatusResults = new ArrayList<>();
        bookStatusDao.find()
                .forEach(bookStatus -> bookStatusResults.add
                        (bookStatusResultConverter.convert(bookStatus)));
        return bookStatusResults;
    }
}
