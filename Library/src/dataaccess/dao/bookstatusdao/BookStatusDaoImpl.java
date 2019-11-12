package dataaccess.dao.bookstatusdao;

import data.entity.BookStatus;

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
        bookStatuses.addAll(entity);
        return entity;
    }

    @Override
    public BookStatus update(BookStatus entity) {
        delete(entity.getId());
        bookStatuses.add(entity);
        return entity;
    }

    @Override
    public List<BookStatus> update(List<BookStatus> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        BookStatus removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(BookStatus entity) {
        bookStatuses.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<BookStatus> find() {
        return bookStatuses;
    }

    @Override
    public BookStatus find(Long id) {
        return bookStatuses
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
