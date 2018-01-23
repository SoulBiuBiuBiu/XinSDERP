
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.Mjlb;

import i.thinker.org.dao.MjlbDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("mjlbDao")
public class MjlbDaoImpl extends BaseDaoImpl<Mjlb> implements MjlbDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
