package presentation.service.departmentservice;

import business.converter.department.DepartmentParam;
import data.common.APIResponse;

import java.util.List;

public interface DepartmentService {
    APIResponse findByPk(long id);
    APIResponse listAll();

    APIResponse create(DepartmentParam param);
    APIResponse create(List<DepartmentParam> param);

    APIResponse update(long id, DepartmentParam param);
    APIResponse update(List<DepartmentParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(DepartmentParam param);
    void validateParameters(List<DepartmentParam> param);
}
