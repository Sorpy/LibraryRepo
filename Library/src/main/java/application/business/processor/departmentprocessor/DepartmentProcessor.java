package application.business.processor.departmentprocessor;

import application.business.converter.department.DepartmentParam;
import application.business.converter.department.DepartmentResult;

import java.util.List;

public interface DepartmentProcessor {
    DepartmentResult create(DepartmentParam param);
    List<DepartmentResult> create(List<DepartmentParam> param);

    void update(Long id,DepartmentParam param);
    void update(List<DepartmentParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    DepartmentResult find(Long id);
    List<DepartmentResult> find();
}
