package dataaccess.dao.bookdao;

import data.entity.Book;

import java.util.List;

import static dataaccess.dao.bookdao.BookData.*;

public class BookDaoImpl implements BookDao{
    @Override
    public Book save(Book entity) {
        bookMap.putIfAbsent(entity.getId(), entity);
        books.add(entity);

        return entity;
    }

    @Override
    public List<Book> save (List<Book> entity) {
        books.addAll(entity);
        return entity;
    }

    @Override
    public Book update(Book entity) {
        delete(entity.getId());
        books.add(entity);
        return entity;
    }

    @Override
    public List<Book> update(List<Book> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Book removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Book entity) {
        books.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Book> find() {
        return books;
    }

    @Override
    public Book find(Long id) {
        return books
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
