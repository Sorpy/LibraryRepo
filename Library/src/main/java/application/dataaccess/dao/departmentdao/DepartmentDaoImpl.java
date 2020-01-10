package application.dataaccess.dao.departmentdao;

import application.data.entity.Department;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class DepartmentDaoImpl extends BaseDaoFileImpl<Department,Long, DepartmentDataImpl> implements DepartmentDao {

    @Override
    public Long getPK(Department department) {
        return department.getId();
    }
}
