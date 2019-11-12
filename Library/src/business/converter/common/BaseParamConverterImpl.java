package business.converter.common;

import business.converter.accountclient.AccountClientParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entity.AccountClient;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.reflect.FieldUtils.*;

public abstract class BaseParamConverterImpl <Tin,Tout> implements BaseParamConverter<Tin,Tout> {

    @Override
    public Tout convertStandart(Tin param, Tout entity) {

        Map<String, Field> paramInfo = new HashMap<>();
        for (Field field : getAllFieldsList(param.getClass())) {
            field.setAccessible(true);
            paramInfo.put(field.getName(), field);
        }
        Map<String, Field> entityInfo = new HashMap<>();
        for (Field field : getAllFieldsList(entity.getClass())) {
            field.setAccessible(true);
            entityInfo.put(field.getName(), field);
        }

        paramInfo.forEach((key, value) -> {
            try {
                if (value.isAnnotationPresent(SkipField.class)) {
                    return;
                }
                if (entityInfo.containsKey(key)) {
                    writeField(entity, key, value.get(param), true);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }

        });
        return entity;
    }


    @Override
    public abstract Tout convertSpecific(Tin param, Tout entity);
}
