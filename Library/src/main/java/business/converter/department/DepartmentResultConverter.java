package business.converter.department;

import business.converter.common.BaseResultConverter;
import data.entity.Department;

public interface DepartmentResultConverter extends BaseResultConverter<Department,DepartmentResult> {
    DepartmentResult convert(Department param);
}
