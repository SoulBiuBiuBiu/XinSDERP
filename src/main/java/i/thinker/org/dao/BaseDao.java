package i.thinker.org.dao;

import java.io.Serializable;
import java.util.List;

import i.thinker.org.enity.GmsAuthRule;
import org.hibernate.criterion.DetachedCriteria;



public interface BaseDao<T> {
	//增
	void save(T t);
	//删
	void delete(T t);
	//删
	void delete(Serializable id);
	//改
	void update(T t);
	//查 根据id查询
	T	getById(Serializable id);
	//查 符合条件的总记录数
	Integer	getTotalCount(DetachedCriteria dc);
	//查 查询分页列表数据
	List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize);
	
	T getByModel(T model);

    List<T> getListByModel(T gmsauthrule);
}
