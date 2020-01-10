package application.dataaccess.dao.common.commonstorage;

import application.data.common.Persistent;

import java.io.File;
import java.util.HashMap;

public interface BaseStorage<PK,ENT extends Persistent> {
    File getPath();
    HashMap<PK,ENT> getMap();

    void saveToDataSource();
    void loadFromDataSource();
}
