package application.business.processor.departmentprocessor;

import application.business.converter.department.*;
import application.business.processor.common.BaseProcessorImpl;
import application.data.entity.Department;
import application.dataaccess.dao.departmentdao.DepartmentDao;
import application.dataaccess.dao.departmentdao.DepartmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DepartmentProcessorImpl
    extends BaseProcessorImpl<DepartmentParam,Department,DepartmentResult, Long, DepartmentDao, DepartmentParamConverter, DepartmentResultConverter>
        implements DepartmentProcessor{

}
