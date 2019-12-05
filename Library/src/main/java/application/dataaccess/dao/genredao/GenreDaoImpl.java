package application.dataaccess.dao.genredao;

import application.data.entity.Genre;
import application.dataaccess.dao.common.BaseStorage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre save(Genre entity) {
        GenreData.genreMap.putIfAbsent(entity.getId(), entity);
        GenreData.genres.add(entity);
        BaseStorage.saveToDataSource();
        return entity;
    }

    @Override
    public List<Genre> save (List<Genre> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public Genre update(Genre entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Genre> update(List<Genre> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Genre removeEntity = find(id);
        delete(removeEntity);
        BaseStorage.saveToDataSource();
    }

    @Override
    public void delete(Genre entity) {
        GenreData.genreMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Genre> find() {
        return new ArrayList<>(GenreData.genreMap.values());
    }

    @Override
    public Genre find(Long id) {
        return new ArrayList<>(GenreData.genreMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
