package i.thinker.org.service.impl;

import i.thinker.org.dao.BaseDao;
import i.thinker.org.dao.impl.BaseDaoImpl;
import i.thinker.org.service.BaseService;
import i.thinker.org.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {


    public BaseDao<T> getBaseDao() {
        return baseDao;
    }

    public void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    BaseDao<T> baseDao;

    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        Integer totalCount=baseDao.getTotalCount(dc);
        PageBean pageBean=new PageBean(currentPage,totalCount,pageSize);
        List<T> list= baseDao.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(T t) {
        baseDao.save(t);
    }

    @Override
    public void delete(T t) {
        baseDao.delete(t);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public T getById(Serializable id) {
        return baseDao.getById(id);
    }

    @Override
    public Integer getTotalCount(DetachedCriteria dc) {
        return baseDao.getTotalCount(dc);
    }
    
    @Override
    public T getByModel(T model) {
        return baseDao.getByModel(model);
    }

	@Override
	public List<T> getListByModel(T g) {
		return baseDao.getListByModel(g);
	}
}
