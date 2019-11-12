package business.converter.department;

import data.entity.Department;

public interface DepartmentParamConverter {

    Department convert(DepartmentParam param, Department oldEntity);
}
