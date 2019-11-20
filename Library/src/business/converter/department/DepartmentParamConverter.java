package business.converter.department;

import business.converter.common.BaseParamConverter;
import data.entity.Department;

public interface DepartmentParamConverter  extends BaseParamConverter<DepartmentParam,Department> {

    Department convert(DepartmentParam param, Department oldEntity);
}
