package application.dataaccess.dao.authordao;

import application.data.entity.Author;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class AuthorDataImpl extends BaseStorageImpl<Long, Author> implements AuthorData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\AuthorJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(Author author) {
        return author.getId();
    }
}
