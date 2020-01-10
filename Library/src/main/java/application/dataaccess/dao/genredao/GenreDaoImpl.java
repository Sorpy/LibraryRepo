package application.dataaccess.dao.genredao;

import application.data.entity.Genre;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class GenreDaoImpl extends BaseDaoFileImpl<Genre,Long, GenreDataImpl> implements GenreDao {

    @Override
    public Long getPK(Genre genre) {
        return genre.getId();
    }
}
