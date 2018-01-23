
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.GmsAuthGroup;

import i.thinker.org.dao.GmsAuthGroupDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("gmsauthgroupDao")
public class GmsAuthGroupDaoImpl extends BaseDaoImpl<GmsAuthGroup> implements GmsAuthGroupDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
