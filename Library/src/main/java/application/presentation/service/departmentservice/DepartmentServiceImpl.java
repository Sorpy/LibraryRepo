package application.presentation.service.departmentservice;

import application.business.converter.department.DepartmentParam;
import application.business.converter.department.DepartmentResult;
import application.business.processor.departmentprocessor.DepartmentProcessor;
import application.business.processor.departmentprocessor.DepartmentProcessorImpl;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.SerializationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private SerializationImpl serializationImpl;
    @Autowired
    private DepartmentProcessor departmentProcessor;

    @Override
    public APIResponse findByPk(long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(departmentProcessor.find(id)));
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
            response.setText(serializationImpl.serialization(departmentResults));
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
            response.setText(serializationImpl.serialization(departmentResult));
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
            response.setText(serializationImpl.serialization(departmentProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, DepartmentParam param) {
        APIResponse response = new APIResponse();
        try {
            departmentProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<DepartmentParam> param) {
        APIResponse response = new APIResponse();
        try {
            departmentProcessor.update(param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
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
