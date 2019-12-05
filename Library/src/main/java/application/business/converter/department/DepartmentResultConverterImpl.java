package application.business.converter.department;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentResultConverterImpl extends BaseResultConverterImpl<Department,DepartmentResult> implements DepartmentResultConverter {
    @Override
    public DepartmentResult convert(Department param) {
        DepartmentResult departmentResult = new DepartmentResult();
        departmentResult = convertStandart(param,departmentResult);
        return departmentResult;
    }

    @Override
    public DepartmentResult convertSpecific(Department entity, DepartmentResult result) {
        return null;
    }
}
