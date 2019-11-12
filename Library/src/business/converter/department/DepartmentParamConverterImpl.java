package business.converter.department;

import data.entity.Department;

public class DepartmentParamConverterImpl implements DepartmentParamConverter {

    @Override
    public Department convert(DepartmentParam param, Department oldEntity) {
        Department entity = null;
        if (oldEntity != null) {
            entity = oldEntity;
        } else {
            entity = new Department();
            entity.setCode(param.getCode());
            entity.setId(param.getId());
        }
        entity.setName(param.getName());
        entity.setDescription(param.getDescription());
        return entity;
    }
}
