
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.Cpck;

import i.thinker.org.dao.CpckDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("cpckDao")
public class CpckDaoImpl extends BaseDaoImpl<Cpck> implements CpckDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
