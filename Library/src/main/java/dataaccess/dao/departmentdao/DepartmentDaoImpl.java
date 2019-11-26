package dataaccess.dao.departmentdao;

import data.entity.Department;

import java.util.ArrayList;
import java.util.List;

import static dataaccess.dao.departmentdao.DepartmentData.*;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public Department save(Department entity) {
        departmentMap.putIfAbsent(entity.getId(), entity);
        departments.add(entity);

        return entity;
    }

    @Override
    public List<Department> save (List<Department> entity) {
        entity.forEach(this::save);
        return entity;
    }

    @Override
    public Department update(Department entity) {
        delete(entity.getId());
        save(entity);
        return entity;
    }

    @Override
    public List<Department> update(List<Department> entity) {
        entity.forEach(this::update);
        return entity;
    }

    @Override
    public void delete(Long id) {
        Department removeEntity = find(id);
        delete(removeEntity);
    }

    @Override
    public void delete(Department entity) {
        departmentMap.remove(entity.getId(),entity);
    }

    @Override
    public void delete(List<Long> idList) {
        idList.forEach(this::delete);
    }

    @Override
    public List<Department> find() {
        return new ArrayList<>(departmentMap.values());
    }

    @Override
    public Department find(Long id) {
        return new ArrayList<>(departmentMap.values())
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst().get();
    }
}
