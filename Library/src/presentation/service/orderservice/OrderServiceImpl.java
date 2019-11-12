package presentation.service.orderservice;

import business.converter.order.OrderParam;
import business.converter.order.OrderResult;
import business.processor.orderprocessor.OrderProcessor;
import business.processor.orderprocessor.OrderProcessorImpl;
import data.common.APIResponse;
import presentation.jsonconverter.Serialization;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    private Serialization serialization = new Serialization();
    private OrderProcessor orderProcessor;

    public OrderProcessor getOrderProcessor() {
        return orderProcessor;
    }

    public void setOrderProcessor(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public APIResponse findByPK(long id){
        APIResponse response = new APIResponse();
        try {
            response.setText(serialization.serialization(orderProcessor.find(id)));
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
            List<OrderResult> orderResults = orderProcessor.find();
            response.setText(serialization.serialization(orderResults));
            response.setResult(true);
        } catch (Exception e) {
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(OrderParam param) {
        APIResponse response = new APIResponse();
        try{
            OrderResult genreResult = orderProcessor.create(param);
            response.setText(serialization.serialization(genreResult));
            response.setResult(true);
        } catch (Exception e){
            response.setText("Something went wrong "+ e.toString());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public APIResponse create(List<OrderParam> param) {
        APIResponse response = new APIResponse();
        try{
            response.setResult(true);
            response.setText(serialization.serialization(orderProcessor.create(param)));
        } catch(Exception e) {
            response.setText("Something went wrong " + e.toString());
            response.setResult(false);
        }
        return response;
    }

    @Override
    public APIResponse update(long id, OrderParam param) {
        APIResponse response = new APIResponse();
        orderProcessor.update(id,param);
        return response;
    }

    @Override
    public APIResponse update(List<OrderParam> param) {
        return null;
    }

    @Override
    public APIResponse deleteById(long id) {
        APIResponse response = new APIResponse();
        try {
            orderProcessor.delete(id);
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
            orderProcessor.delete(idList);
            response.setResult(true);
            response.setText("deleted element with IDs: " + idList.toString());
        } catch (Exception e){
            response.setText("Something went wrong " + e.getMessage());
            response.setResult(false);
        }

        return response;
    }

    @Override
    public void validateParameters(OrderParam param) {

    }

    @Override
    public void validateParameters(List<OrderParam> param) {

    }
}
