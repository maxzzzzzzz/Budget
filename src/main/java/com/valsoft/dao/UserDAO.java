package com.valsoft.dao;

import com.valsoft.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
@Repository
public class UserDAO extends AbstractDAO<Long, User> implements IUserDAO {
    @Override
    public User findById(Long id) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("USER_ID", id));
//        return (User) criteria.uniqueResult();
        return getByKey(id);
    }

    @Override
    public void saveUser(User user) {
        persist(user);

    }

    @Override
    public void deleteUserById(Long id) {
        Query query = getSession().createSQLQuery("delete from USER1 where USER1_ID = :id");
        query.setLong("USER1_ID",id);
        query.executeUpdate();

    }

    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
