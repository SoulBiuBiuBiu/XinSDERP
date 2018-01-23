
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.Yllb;

import i.thinker.org.dao.YllbDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("yllbDao")
public class YllbDaoImpl extends BaseDaoImpl<Yllb> implements YllbDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
