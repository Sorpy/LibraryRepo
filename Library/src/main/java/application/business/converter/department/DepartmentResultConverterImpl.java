package application.business.converter.department;

import application.business.converter.common.BaseResultConverterImpl;
import application.data.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentResultConverterImpl extends BaseResultConverterImpl<Department,DepartmentResult> implements DepartmentResultConverter {


    @Override
    public void convertSpecific(Department entity, DepartmentResult result) {
    }

    @Override
    public DepartmentResult getResult() {
        return new DepartmentResult();
    }
}
