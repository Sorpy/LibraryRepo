package business.processor.accountlibrarianprocessor;

import business.converter.accountlibrarian.AccountLibrarianParam;
import business.converter.accountlibrarian.AccountLibrarianResult;

import java.util.List;

public interface AccountLibrarianProcessor {
    AccountLibrarianResult create(AccountLibrarianParam param);
    List<AccountLibrarianResult> create(List<AccountLibrarianParam> param);

    void update(Long id,AccountLibrarianParam param);
    void update(List<AccountLibrarianParam> param);

    void delete(Long id);
    void delete(List<Long> idList);

    AccountLibrarianResult find(Long id);
    List<AccountLibrarianResult> find(String name);
    List<AccountLibrarianResult> find();
}
