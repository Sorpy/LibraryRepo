package application.dataaccess.dao.departmentdao;

import application.data.entity.Department;
import application.dataaccess.dao.common.BaseDao;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department, Long> {
    Department save(Department entity);
    List<Department> save(List<Department> entity);

    Department update(Department entity);
    List<Department> update(List<Department> entity);

    void delete(Long id);
    void delete(Department entity);
    void delete(List<Long> idList);

    List<Department> find();
    Department find(Long id);
}
