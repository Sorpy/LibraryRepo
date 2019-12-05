package application.dataaccess.dao.common;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseStorage {
    public static File file;
    public static HashMap map;
    public static File getPath(){
        return file;
    }
    public static HashMap getMap(){
        return map;
    }


    public static void saveToDataSource(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(String.valueOf(getPath())), getMap().values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
