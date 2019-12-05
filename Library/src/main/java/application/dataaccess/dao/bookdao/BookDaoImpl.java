package application.dataaccess.dao.bookdao;

import application.data.entity.Book;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookDaoImpl implements BookDao{
    @Override
    public Book save(Book entity) {
        BookData.bookMap.putIfAbsent(entity.getId(), entity);
        //BookData.books.add(entity);
        BaseStorage.saveToDataSource();
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
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(Book entity) {
        BookData.bookMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Book> find() {
        return new ArrayList<>(BookData.bookMap.values());
    }

    @Override
    public Book find(Long id) {
        return new ArrayList<>(BookData.bookMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
