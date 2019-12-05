package application.dataaccess.dao.bookstatusdao;

import application.data.entity.BookStatus;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookStatusDaoImpl implements BookStatusDao {
    @Override
    public BookStatus save(BookStatus entity) {
        BookStatusData.bookStatusMap.putIfAbsent(entity.getId(), entity);
        BookStatusData.bookStatuses.add(entity);
        BaseStorage.saveToDataSource();
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
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(BookStatus entity) {
        BookStatusData.bookStatusMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<BookStatus> find() {
        return new ArrayList<>(BookStatusData.bookStatusMap.values());
    }

    @Override
    public BookStatus find(Long id) {
        return new ArrayList<>(BookStatusData.bookStatusMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
