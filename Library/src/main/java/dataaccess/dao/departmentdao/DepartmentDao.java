package dataaccess.dao.departmentdao;

import data.entity.Department;

import java.util.List;

public interface DepartmentDao {
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
