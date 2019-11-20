package dataaccess.dao.genredao;

import data.entity.Genre;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.genredao.GenreData.*;

public class GenreDaoImpl implements GenreDao {
    @Override
    public Genre save(Genre entity) {
        genreMap.putIfAbsent(entity.getId(), entity);
        genres.add(entity);

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
    }

    @Override
    public void delete(Genre entity) {
        genreMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Genre> find() {
        return new ArrayList<>(genreMap.values());
    }

    @Override
    public Genre find(Long id) {
        return new ArrayList<>(genreMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
