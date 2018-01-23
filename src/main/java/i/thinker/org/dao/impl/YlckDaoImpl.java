
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.Ylck;

import i.thinker.org.dao.YlckDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("ylckDao")
public class YlckDaoImpl extends BaseDaoImpl<Ylck> implements YlckDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
