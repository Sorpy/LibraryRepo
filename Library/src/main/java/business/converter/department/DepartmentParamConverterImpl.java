package business.converter.department;

import business.converter.IllegalConvertException;
import business.converter.common.BaseParamConverterImpl;
import data.entity.Department;

public class DepartmentParamConverterImpl extends BaseParamConverterImpl<DepartmentParam,Department> implements DepartmentParamConverter {

    @Override
    public Department convert(DepartmentParam param, Department oldEntity) {
        Department entity = null;
        if (oldEntity != null) {
            if (param.getId().equals(oldEntity.getId()) && param.getUnicode().equals(oldEntity.getCode())) {
                entity = oldEntity;
            } else {
                try {
                    throw new IllegalConvertException("Id and/or code do  not match");
                } catch (IllegalConvertException e) {
                    e.printStackTrace();
                }
            }
        } else {
            entity = new Department();
            entity.setId(param.getId());
            //entity.setCode(param.getUnicode());
        }
        entity = convertStandart(param, entity);
        return entity;
    }

    @Override
    public Department convertSpecific(DepartmentParam param, Department entity) {
        return null;
    }
}

