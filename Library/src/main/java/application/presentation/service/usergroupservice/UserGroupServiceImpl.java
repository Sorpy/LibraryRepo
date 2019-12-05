package application.presentation.service.usergroupservice;

import application.business.converter.usergroup.UserGroupParam;
import application.business.converter.usergroup.UserGroupResult;
import application.business.processor.usergroupprocessor.UserGroupProcessor;
import application.business.processor.usergroupprocessor.UserGroupProcessorImpl;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.SerializationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserGroupServiceImpl implements UserGroupService{
    @Autowired
    private SerializationImpl serializationImpl;
    @Autowired
    private UserGroupProcessor userGroupProcessor;

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serializationImpl.serialization(userGroupProcessor.find(id)));
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
            List<UserGroupResult> userGroupResults = userGroupProcessor.find();
            response.setText(serializationImpl.serialization(userGroupResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UserGroupParam param) {
        APIResponse response = new APIResponse();
        try{
            UserGroupResult userGroupResult = userGroupProcessor.create(param);
            response.setText(serializationImpl.serialization(userGroupResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UserGroupParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization(userGroupProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, UserGroupParam param) {
        APIResponse response = new APIResponse();
        try {
            userGroupProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UserGroupParam> param) {
        APIResponse response = new APIResponse();
        try {
            userGroupProcessor.update(param);
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
            userGroupProcessor.delete(id);
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
            userGroupProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UserGroupParam param) {

    }

    @Override
    public void validateParameters(List<UserGroupParam> param) {

    }
}
