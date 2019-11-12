package dataaccess.dao.genredao;

import data.entity.Genre;

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
        genres.addAll(entity);
        return entity;
    }

    @Override
    public Genre update(Genre entity) {
        delete(entity.getId());
        genres.add(entity);
        return entity;
    }

    @Override
    public List<Genre> update(List<Genre> entity) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Genre removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Genre entity) {
        genres.remove(entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Genre> find() {
        return genres;
    }

    @Override
    public Genre find(Long id) {
        return genres
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
