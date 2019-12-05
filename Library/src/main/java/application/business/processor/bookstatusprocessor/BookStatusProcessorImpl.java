package application.business.processor.bookstatusprocessor;

import application.business.converter.bookstatus.*;
import application.data.entity.BookStatus;
import application.dataaccess.dao.bookstatusdao.BookStatusDao;
import application.dataaccess.dao.bookstatusdao.BookStatusDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookStatusProcessorImpl implements BookStatusProcessor{
    @Autowired
    private BookStatusDao bookStatusDao;
    @Autowired
    private BookStatusParamConverter bookStatusParamConverter;
    @Autowired
    private BookStatusResultConverter bookStatusResultConverter;


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
        List<BookStatus> bookStatuses = new ArrayList<>();
        param.forEach(bookStatusParam -> bookStatuses
                .add(bookStatusParamConverter
                        .convert(bookStatusParam,null)));
        bookStatusDao.update(bookStatuses);
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
