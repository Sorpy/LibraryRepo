package application.dataaccess.dao.departmentdao;

import application.data.entity.Department;
import application.dataaccess.dao.common.commonstorage.BaseStorageImpl;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class DepartmentDataImpl extends BaseStorageImpl<Long, Department> implements DepartmentData {
    @Override
    public File getPath(){
        return new File(".\\src\\main\\java\\application\\database\\DepartmentJSON");
    }

    @Override
    public Long getPK(Department department) {
        return department.getId();
    }
}