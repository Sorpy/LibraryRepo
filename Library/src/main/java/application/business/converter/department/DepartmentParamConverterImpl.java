package application.business.converter.department;

import application.business.converter.IllegalConvertException;
import application.business.converter.common.BaseParamConverterImpl;
import application.data.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentParamConverterImpl
        extends BaseParamConverterImpl<DepartmentParam,Department>
        implements DepartmentParamConverter {


    @Override
    public void convertSpecific(DepartmentParam param, Department entity) {
    }

    @Override
    public Department getEntity(DepartmentParam param) {
        Department department = new Department();
        department.setCode(param.getCode());
        department.setId(param.getId());
        return department;
    }
}

