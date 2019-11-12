package presentation.service.departmentservice;

import business.converter.department.DepartmentParam;
import business.converter.department.DepartmentResult;
import business.processor.departmentprocessor.DepartmentProcessor;
import business.processor.departmentprocessor.DepartmentProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private Serialization serialization = new Serialization();
    private DepartmentProcessor departmentProcessor = new DepartmentProcessorImpl();

    public DepartmentProcessor getDepartmentProcessor() {
        return departmentProcessor;
    }

    public void setDepartmentProcessor(DepartmentProcessor departmentProcessor) {
        this.departmentProcessor = departmentProcessor;
    }

    @Override
    public APIResponse findByPk(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(departmentProcessor.find(id)));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse listAll() {
        APIResponse response = new APIResponse();
        try {
            List<DepartmentResult> departmentResults = departmentProcessor.find();
            response.setText(serialization.serialization(departmentResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(DepartmentParam param) {
        APIResponse response = new APIResponse();
        try{
            DepartmentResult departmentResult = departmentProcessor.create(param);
            response.setText(serialization.serialization(departmentResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<DepartmentParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(departmentProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, DepartmentParam param) {
        APIResponse response = new APIResponse();
        departmentProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<DepartmentParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            departmentProcessor.delete(id);
            response.setResult(true);
            response.setText("deleted element with ID: " + id);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse delete(List<Long> idList) {
        APIResponse response = new APIResponse();
        try {
            departmentProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(DepartmentParam param) {

    }

    @Override
    public void validateParameters(List<DepartmentParam> param) {

    }
}
