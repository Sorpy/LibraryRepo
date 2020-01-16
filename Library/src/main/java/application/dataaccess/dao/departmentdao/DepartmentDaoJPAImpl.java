package application.dataaccess.dao.departmentdao;

import application.data.entity.Department;
import application.dataaccess.dao.common.commondao.BaseDaoJPAImpl;

public class DepartmentDaoJPAImpl extends BaseDaoJPAImpl<Department,Long> implements DepartmentDao {
    @Override
    public Class<Department> getMyType() {
        return Department.class;
    }
}
