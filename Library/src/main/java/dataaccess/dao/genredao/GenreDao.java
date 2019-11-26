package dataaccess.dao.genredao;

import data.entity.Genre;

import java.util.List;

public interface GenreDao {
    Genre save(Genre entity);
    List<Genre> save(List<Genre> entity);

    Genre update(Genre entity);
    List<Genre> update(List<Genre> entity);

    void delete(Long id);
    void delete(Genre entity);
    void delete(List<Long> idList);

    List<Genre> find();
    Genre find(Long id);
}
