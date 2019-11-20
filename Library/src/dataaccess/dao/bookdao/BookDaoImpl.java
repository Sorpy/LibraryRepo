package dataaccess.dao.bookdao;

import data.entity.Book;

import java.util.ArrayList;
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
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public Book update(Book entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Book> update(List<Book> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Book removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Book entity) {
        bookMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Book> find() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book find(Long id) {
        return new ArrayList<>(bookMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
