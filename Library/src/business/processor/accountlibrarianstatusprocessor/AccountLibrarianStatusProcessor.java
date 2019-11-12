package business.processor.accountlibrarianstatusprocessor;

import business.converter.accountlibrarianstatus.AccountLibrarianStatusParam;
import business.converter.accountlibrarianstatus.AccountLibrarianStatusResult;

import java.util.List;

public interface AccountLibrarianStatusProcessor {
    AccountLibrarianStatusResult create(AccountLibrarianStatusParam param);
    List<AccountLibrarianStatusResult> create(List<AccountLibrarianStatusParam> param);

    void update(Long id,AccountLibrarianStatusParam param);
    void update(List<AccountLibrarianStatusParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountLibrarianStatusResult find(Long id);
    List<AccountLibrarianStatusResult> find();
}
