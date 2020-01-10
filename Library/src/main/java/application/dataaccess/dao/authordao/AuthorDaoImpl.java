package application.dataaccess.dao.authordao;

import application.data.entity.Author;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class AuthorDaoImpl extends BaseDaoFileImpl<Author,Long, AuthorData> implements AuthorDao {

    @Override
    public Long getPK(Author author) {
        return author.getId();
    }
}
