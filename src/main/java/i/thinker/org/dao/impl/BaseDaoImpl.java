package i.thinker.org.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import i.thinker.org.dao.BaseDao;
import i.thinker.org.enity.GmsAuthRule;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;



public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;//用于接收运行期泛型类型
	
	
	public BaseDaoImpl() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		
		getHibernateTemplate().delete(t);
		
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);//先取,再删
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

	@Override
	public T getById(Serializable id) {
		
		
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置查询的聚合函数,总记录数
		dc.setProjection(Projections.rowCount());
		
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		
		//清空之前设置的聚合函数
		dc.setProjection(null);
		
		if(list!=null && list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
			return null;
		}
		
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		
		return list;
	}
	
	@Override
	public T getByModel(T model) {
		List<T> list = getHibernateTemplate().findByExample(model);
		if(list.size()!=0)
			return list.get(0);
		return null;
	}

	@Override
	public List<T> getListByModel(T gmsauthrule) {
		return getHibernateTemplate().findByExample(gmsauthrule);
	}


}
