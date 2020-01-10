package application.dataaccess.dao.bookdao;

import application.data.entity.Book;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class BookDataImpl extends BaseStorageImpl<Long, Book> implements BookData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\BookJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(Book book) {
        return book.getId();
    }
}
