package business.processor.bookprocessor;

import business.converter.book.*;
import data.entity.Book;
import dataaccess.dao.bookdao.BookDao;
import dataaccess.dao.bookdao.BookDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class BookProcessorImpl implements BookProcessor{
    private BookDao bookDao = new BookDaoImpl();
    private BookParamConverter bookParamConverter = new BookParamConverterImpl();
    private BookResultConverter bookResultConverter = new BookResultConverterImpl();


    @Override
    public BookResult create(BookParam param) {
        return bookResultConverter.convert
                (bookDao.save
                        (bookParamConverter.convert(param,null)));
    }

    @Override
    public List<BookResult> create(List<BookParam> param) {
        List<Book> books = new ArrayList<>();
        List<BookResult> bookResults = new ArrayList<>();

        param.forEach
                (book -> books.add
                        (bookParamConverter.convert
                                (book,null)));
        bookDao.save(books);
        books.forEach
                (book -> bookResults.add
                        (bookResultConverter.convert(book)));

        return bookResults;
    }

    @Override
    public void update(Long id, BookParam param) {
        Book oldEntity = bookDao.find(id);
        if (oldEntity!=null){
            bookDao.update
                    (bookParamConverter.convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<BookParam> param) {

    }

    @Override
    public void delete(Long id) {
        bookDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        bookDao.delete(idList);
    }

    @Override
    public BookResult find(Long id) {
        return bookResultConverter.convert(bookDao.find(id));
    }

    @Override
    public List<BookResult> find() {
        List<BookResult> bookResults = new ArrayList<>();
        bookDao.find()
                .forEach(book -> bookResults.add
                        (bookResultConverter.convert(book)));
        return bookResults;
    }
}
