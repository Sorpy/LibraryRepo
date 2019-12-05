package application.presentation.service.usergroupstatusservice;

import application.business.converter.usergroupstatus.UserGroupStatusParam;
import application.business.converter.usergroupstatus.UserGroupStatusResult;
import application.business.processor.usergroupstatusprocessor.UserGroupStatusProcessor;
import application.business.processor.usergroupstatusprocessor.UserGroupStatusProcessorImpl;
import application.data.common.APIResponse;
import application.presentation.jsonconverter.SerializationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserGroupStatusServiceImpl implements UserGroupStatusService{
    @Autowired
    private SerializationImpl serializationImpl;
    @Autowired
    private UserGroupStatusProcessor userGroupStatusProcessor;

    @Override
    public APIResponse findByPK(Long id) {
        APIResponse response = new APIResponse();
        try {
            response.setText
                    (serializationImpl.serialization
                            (userGroupStatusProcessor.find(id)));
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
            List<UserGroupStatusResult> accountClientResults = userGroupStatusProcessor.find();
            response.setText(serializationImpl.serialization(accountClientResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(UserGroupStatusParam param) {
        APIResponse response = new APIResponse();
        try{
            UserGroupStatusResult userGroupStatusResult = userGroupStatusProcessor.create(param);
            response.setText(serializationImpl.serialization(userGroupStatusResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e);
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<UserGroupStatusParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serializationImpl.serialization
                    (userGroupStatusProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(Long id, UserGroupStatusParam param) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.update(id,param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse update(List<UserGroupStatusParam> param) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.update(param);
            response.setResult(true);
            response.setText("updated list");
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse deleteById(Long id) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.delete(id);
            response.setResult(true);
            response.setText("deleted element with ID: " + id);
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse delete(List<Long> idList) {
        APIResponse response = new APIResponse();
        try {
            userGroupStatusProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(UserGroupStatusParam param) {

    }

    @Override
    public void validateParameters(List<UserGroupStatusParam> param) {

    }
}
