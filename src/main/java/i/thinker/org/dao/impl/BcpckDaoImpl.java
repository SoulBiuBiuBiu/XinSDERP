
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.Bcpck;

import i.thinker.org.dao.BcpckDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("bcpckDao")
public class BcpckDaoImpl extends BaseDaoImpl<Bcpck> implements BcpckDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
