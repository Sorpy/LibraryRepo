package application.business.processor.departmentprocessor;

import application.business.converter.department.DepartmentParam;
import application.business.converter.department.DepartmentParamConverter;
import application.business.converter.department.DepartmentResult;
import application.business.converter.department.DepartmentResultConverter;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Department;
import application.dataaccess.dao.departmentdao.DepartmentDao;
import org.springframework.stereotype.Component;
@Component
public class DepartmentProcessorImpl
    extends BaseProcessorImpl<DepartmentParam,Department,DepartmentResult, Long, DepartmentDao, DepartmentParamConverter, DepartmentResultConverter>
        implements DepartmentProcessor{

    @Override
    public Long getPK(DepartmentParam ent) {
        return  ent.getId();

    }
}
