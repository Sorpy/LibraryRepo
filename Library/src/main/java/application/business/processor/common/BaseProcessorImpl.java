package application.business.processor.common;

import application.business.converter.common.BaseParamConverter;
import application.business.converter.common.BaseResultConverter;
import application.dataaccess.dao.common.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class BaseProcessorImpl <IN,ENT,OUT,PK,
        DAO extends BaseDao<ENT,PK>,
        PConvert extends BaseParamConverter<IN,ENT>,
        RConvert extends BaseResultConverter<ENT,OUT>>
        implements BaseProcessor <IN, OUT,PK>{

    @Autowired
    private DAO dao;
    @Autowired
    private PConvert paramConverter;
    @Autowired
    private RConvert resultConverter;

    @Override
    public OUT create(IN param) {
        
        return resultConverter
                .convert(dao
                        .save(paramConverter
                                .convert(param,null)));
    }

    @Override
    public List<OUT> create(List<IN> param) {
        List<ENT> entities = new ArrayList<>();
        List<OUT> results = new ArrayList<>();


        param.forEach
                (entity -> entities
                        .add(paramConverter
                                .convert(entity,null)));
        dao.save(entities);
        entities.forEach
                (entity -> {
                    try {
                        results
                                .add(resultConverter
                                        .convert(entity));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

        return results;
    }

    @Override
    public void update(PK id, IN param) {
        ENT oldEntity = dao.find(id);
        if (oldEntity!=null){
            dao.update
                    (paramConverter.convert
                            (param,oldEntity));
        }else
            System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<IN> param) {
        List<ENT> entities = new ArrayList<>();
        param.forEach(entity -> entities
                .add(paramConverter
                        .convert(entity,null)));
        dao.update(entities);
    }

    @Override
    public void delete(PK id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(List<PK> idList) {
        dao.delete(idList);
    }

    @Override
    public OUT find(PK id) {
        return resultConverter
                .convert(dao.find(id));
    }

    @Override
    public List<OUT> find() {
        List<OUT> results = new ArrayList<>();
        dao.find()
                .forEach(entity -> {
                    try {
                        results
                                .add(resultConverter
                                        .convert(entity));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return results;
    }

    @Override
    public List<OUT> find(String name, String value) throws InvocationTargetException, NoSuchMethodException, IntrospectionException, IllegalAccessException, NoSuchFieldException {
        List<OUT> results = new ArrayList<>();
        dao
                .find(name,value)
                .forEach(entity -> {
                    try {
                        results
                                .add(resultConverter.convert(entity));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        return results;
    }
}
