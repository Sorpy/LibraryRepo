package application.dataaccess.dao.genredao;

import application.data.entity.Genre;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface GenreDao extends BaseDao<Genre, Long> {
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
