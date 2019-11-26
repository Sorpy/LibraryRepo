package presentation.service.bookstatusservice;

import business.converter.bookstatus.BookStatusParam;
import data.common.APIResponse;

import java.util.List;

public interface BookStatusService {
    APIResponse findByPK(long id);
    APIResponse listAll();

    APIResponse create(BookStatusParam param);
    APIResponse create(List<BookStatusParam> param);

    APIResponse update(long id, BookStatusParam param);
    APIResponse update(List<BookStatusParam> param);

    APIResponse deleteById(long id);
    APIResponse delete(List<Long> idList);

    void validateParameters(BookStatusParam param);
    void validateParameters(List<BookStatusParam> param);
}
