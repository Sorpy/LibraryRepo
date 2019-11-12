package business.processor.departmentprocessor;

import business.converter.department.*;
import data.entity.Department;
import dataaccess.dao.departmentdao.DepartmentDao;
import dataaccess.dao.departmentdao.DepartmentDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class DepartmentProcessorImpl implements DepartmentProcessor{
    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private DepartmentParamConverter departmentParamConverter = new DepartmentParamConverterImpl();
    private DepartmentResultConverter departmentResultConverter = new DepartmentResultConverterImpl();


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
