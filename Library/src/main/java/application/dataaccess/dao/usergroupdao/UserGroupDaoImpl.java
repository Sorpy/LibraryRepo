package application.dataaccess.dao.usergroupdao;

import application.data.entity.UserGroup;
import application.dataaccess.dao.common.commondao.BaseDaoFileImpl;
public class UserGroupDaoImpl extends BaseDaoFileImpl<UserGroup,Long, UserGroupDataImpl> implements UserGroupDao{
    @Override
    public Long getPK(UserGroup userGroup) {
        return userGroup.getId();
    }
}
