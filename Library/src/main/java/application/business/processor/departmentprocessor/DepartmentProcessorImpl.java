package application.business.processor.departmentprocessor;

import application.business.converter.department.*;
import application.data.entity.Department;
import application.dataaccess.dao.departmentdao.DepartmentDao;
import application.dataaccess.dao.departmentdao.DepartmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DepartmentProcessorImpl implements DepartmentProcessor{
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private DepartmentParamConverter departmentParamConverter;
    @Autowired
    private DepartmentResultConverter departmentResultConverter;


    @Override
    public DepartmentResult create(DepartmentParam param) {
        return departmentResultConverter
                .convert(departmentDao
                        .save(departmentParamConverter
                                .convert(param,null)));
    }

    @Override
    public List<DepartmentResult> create(List<DepartmentParam> param) {
        List<Department> departments = new ArrayList<>();
        List<DepartmentResult> departmentResults = new ArrayList<>();

        param.forEach(departmentParam -> departments
                .add(departmentParamConverter
                        .convert(departmentParam,null)));
        departmentDao.save(departments);
        departments.forEach(department -> departmentResults
                .add(departmentResultConverter
                        .convert(department)));

        return departmentResults;
    }

    @Override
    public void update(Long id, DepartmentParam param) {
        Department oldEntity = departmentDao.find(id);
        if (oldEntity!=null){
            departmentDao
                    .update(departmentParamConverter
                            .convert(param,oldEntity));
        }else System.out.println("No entity with id " + id + " found");
    }

    @Override
    public void update(List<DepartmentParam> param) {
        List<Department> departments = new ArrayList<>();
        param.forEach(departmentParam -> departments
                .add(departmentParamConverter
                        .convert(departmentParam,null)));
        departmentDao.update(departments);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    @Override
    public void delete(List<Long> idList) {
        departmentDao.delete(idList);
    }

    @Override
    public DepartmentResult find(Long id) {
        return departmentResultConverter
                .convert(departmentDao
                        .find(id));
    }

    @Override
    public List<DepartmentResult> find() {
        List<DepartmentResult> departmentResults = new ArrayList<>();
        departmentDao.find()
                .forEach(department -> departmentResults
                        .add(departmentResultConverter
                                .convert(department)));
        return departmentResults;
    }
}
