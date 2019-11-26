package dataaccess.dao.bookstatusdao;

import data.entity.BookStatus;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.bookstatusdao.BookStatusData.*;

public class BookStatusDaoImpl implements BookStatusDao {
    @Override
    public BookStatus save(BookStatus entity) {
        bookStatusMap.putIfAbsent(entity.getId(), entity);
        bookStatuses.add(entity);

        return entity;
    }

    @Override
    public List<BookStatus> save (List<BookStatus> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public BookStatus update(BookStatus entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<BookStatus> update(List<BookStatus> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        BookStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(BookStatus entity) {
        bookStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<BookStatus> find() {
        return new ArrayList<>(bookStatusMap.values());
    }

    @Override
    public BookStatus find(Long id) {
        return new ArrayList<>(bookStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
