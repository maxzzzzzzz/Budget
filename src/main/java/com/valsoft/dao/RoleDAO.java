package com.valsoft.dao;

import com.valsoft.model.Role;
import com.valsoft.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
@Repository
public class RoleDAO extends AbstractDAO<Long, Role> implements IRoleDAO {

    @Override
    public Role findById(Long id) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("ROLE_ID", id));
//        return (User) criteria.uniqueResult();
        return getByKey(id);    }

    @Override
    public void saveRole(Role role) {
        persist(role);

    }

    @Override
    public void deleteRoleById(Long id) {
        Query query = getSession().createSQLQuery("delete from ROLE where ROLE_ID = :id");
        query.setLong("ROLE_ID",id);
        query.executeUpdate();

    }

    @Override
    public List<Role> findAllRoles() {
        Criteria criteria = createEntityCriteria();
        return (List<Role>) criteria.list();
    }
}
