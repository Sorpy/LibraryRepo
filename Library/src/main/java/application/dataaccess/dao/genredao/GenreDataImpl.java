package application.dataaccess.dao.genredao;

import application.data.entity.Genre;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class GenreDataImpl extends BaseStorageImpl<Long, Genre> implements GenreData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\GenreJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(Genre genre) {
        return genre.getId();
    }
}
