package application.dataaccess.dao.bookstatusdao;

import application.data.entity.BookStatus;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
@Component
public class BookStatusDataImpl extends BaseStorageImpl<Long, BookStatus> implements BookStatusData {

    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\BookStatusJSON");
    }
    @Override public HashMap getMap(){
        return map;
    }

    @Override
    public Long getPK(BookStatus bookStatus) {
        return bookStatus.getId();
    }
}
