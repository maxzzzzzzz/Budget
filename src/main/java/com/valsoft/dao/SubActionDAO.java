package com.valsoft.dao;

import com.valsoft.model.SubAction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asus on 18.06.2017.
 */
@Repository
public class SubActionDAO extends AbstractDAO<Long, SubAction> implements ISubActionDAO {
    @Override
    public SubAction findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void saveSubAction(SubAction subAction) {
        persist(subAction);
    }

    @Override
    public void deleteSubActionById(Long id) {
        Query query = getSession().createSQLQuery("delete from SUB_ACTION where SUB_ACTION_ID = :id");
        query.setLong("SUB_ACTION_ID",id);
        query.executeUpdate();

    }

    @Override
    public List<SubAction> findAllSubActions() {
        Criteria criteria = createEntityCriteria();
        return (List<SubAction>) criteria.list();
    }
}
