package business.converter.department;

import business.converter.common.BaseResultConverterImpl;
import data.entity.Department;

public class DepartmentResultConverterImpl extends BaseResultConverterImpl<Department,DepartmentResult> implements DepartmentResultConverter {
    @Override
    public DepartmentResult convert(Department param) {
        DepartmentResult bookStatusResult = new DepartmentResult();
        bookStatusResult = convertStandart(param,bookStatusResult);
        return bookStatusResult;
    }

    @Override
    public DepartmentResult convertSpecific(Department entity, DepartmentResult result) {
        return null;
    }
}
