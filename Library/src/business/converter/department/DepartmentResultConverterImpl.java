package business.converter.department;

import data.entity.Department;

public class DepartmentResultConverterImpl implements DepartmentResultConverter {
    @Override
    public DepartmentResult convert(Department param) {
        DepartmentResult departmentResult = new DepartmentResult();
        departmentResult.setCode(param.getCode());
        departmentResult.setName(param.getName());
        departmentResult.setDescription(param.getDescription());
        departmentResult.setId(param.getId());
        return departmentResult;
    }
}
