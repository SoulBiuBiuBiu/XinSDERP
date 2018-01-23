
package i.thinker.org.dao.impl;

import i.thinker.org.dao.impl.BaseDaoImpl;

import i.thinker.org.enity.GmsAuthRule;

import i.thinker.org.dao.GmsAuthRuleDao;

import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



@Repository("gmsauthruleDao")
public class GmsAuthRuleDaoImpl extends BaseDaoImpl<GmsAuthRule> implements GmsAuthRuleDao{
    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }
}
