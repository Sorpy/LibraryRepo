package application.business.converter.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.reflect.FieldUtils.*;

public abstract class BaseResultConverterImpl <ENT, OUT> implements BaseResultConverter<ENT, OUT>{

    public OUT convertStandard(ENT entity, OUT result) {
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
    public abstract void convertSpecific(ENT entity, OUT result);

    @Override
    public  OUT convert(ENT entity){
        OUT result = getResult();
        convertStandard(entity,result);
        convertSpecific(entity,result);
        return result;
    }

    public abstract OUT getResult();
}
