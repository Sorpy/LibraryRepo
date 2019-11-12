package presentation.service.usergroupservice;

import business.converter.usergroup.UserGroupParam;
import business.converter.usergroup.UserGroupResult;
import business.processor.usergroupprocessor.UserGroupProcessor;
import business.processor.usergroupprocessor.UserGroupProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class UserGroupServiceImpl implements UserGroupService{
    private Serialization serialization = new Serialization();
    private UserGroupProcessor userGroupProcessor = new UserGroupProcessorImpl();

    public UserGroupProcessor getUserGroupProcessor() {
        return userGroupProcessor;
    }

    public void setUserGroupProcessor(UserGroupProcessor userGroupProcessor) {
        this.userGroupProcessor = userGroupProcessor;
    }

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(userGroupProcessor.find(id)));
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
            response.setText(serialization.serialization(userGroupResults));
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
            response.setText(serialization.serialization(userGroupResult));
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
            response.setText(serialization.serialization(userGroupProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, UserGroupParam param) {
        APIResponse response = new APIResponse();
        userGroupProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<UserGroupParam> param) {
        return null;
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
