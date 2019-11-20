package dataaccess.dao.common;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class BaseStorage {
    public abstract File getPath();
    public abstract List getList();


    public void saveToDataSource(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(String.valueOf(getPath())), getList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
