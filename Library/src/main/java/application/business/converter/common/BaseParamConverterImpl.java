package application.business.converter.common;

import application.business.converter.common.customannotation.Track;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.reflect.FieldUtils.*;

public abstract class BaseParamConverterImpl <IN, ENT > implements BaseParamConverter<IN, ENT> {

    @Override
    public ENT convertStandard(IN param, ENT entity) {

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
                if (value.isAnnotationPresent(Track.class)) {
                   if (value.getAnnotation(Track.class).source().equals(key)){
                       writeField(entity,value.getAnnotation(Track.class).destination(),value.get(param),true);
                   }
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
    public abstract void convertSpecific(IN param, ENT entity);

    @Override
    public ENT convert(IN param, ENT oldEntity){
        ENT entity = null;
        if(oldEntity!=null)
        {
            //if(param.getId().equals(oldEntity.getId())&& param.getCode().equals(oldEntity.getCode())){
                entity = oldEntity;
           /* }
            else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }

            */
        }
        else
        {
            entity = getEntity(param);
        }
        entity = convertStandard(param,entity);
        return entity;
    }

    @Override
    public abstract ENT getEntity(IN param);
}
