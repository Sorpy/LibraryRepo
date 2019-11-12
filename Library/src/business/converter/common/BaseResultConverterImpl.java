package business.converter.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.reflect.FieldUtils.*;

public abstract class BaseResultConverterImpl <Tin,Tout> implements BaseResultConverter<Tin,Tout>{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Tout convertStandart(Tin entity, Tout result) {
        Map<String, Field> entityInfo = new HashMap<>();
        for (Field field : getAllFieldsList(entity.getClass())) {
            field.setAccessible(true);
            entityInfo.put(field.getName(), field);
        }
        Map<String, Field> resultInfo = new HashMap<>();
        for (Field field : getAllFieldsList(result.getClass())) {
            field.setAccessible(true);
            resultInfo.put(field.getName(), field);
        }

        entityInfo.forEach((key,value)-> {
            try {

                if (resultInfo.containsKey(key)) {
                    writeField(result, key,value.get(entity),true);
                }
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
        });
        System.out.println();
        return result;
    }

    @Override
    public abstract Tout convertSpecific(Tin entity, Tout result);
}
