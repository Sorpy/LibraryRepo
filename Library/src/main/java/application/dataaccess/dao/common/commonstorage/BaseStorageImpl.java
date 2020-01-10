package application.dataaccess.dao.common.commonstorage;

import application.data.common.Persistent;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class BaseStorageImpl<PK,ENT extends Persistent> implements BaseStorage<PK,ENT> {
    protected File file;
    protected HashMap<PK,ENT> map;
    private ObjectMapper mapper = new ObjectMapper();
    public abstract File getPath();

    public HashMap<PK,ENT> getMap(){
        return map;
    }

    public void setMap(HashMap<PK,ENT> map) {
        this.map = map;
    }


    public BaseStorageImpl(){
        loadFromDataSource();
    }


    public void saveToDataSource(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(String.valueOf(getPath())), getMap().values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromDataSource() {
        List<ENT> entities;
        try {


            entities = mapper.readValue(getPath(), new TypeReference<List<ENT>>() {
            });
            for (ENT ent: entities) {
                map.put(getPK(ent),ent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract PK getPK(ENT ent);
}
