package i.thinker.org.service;

import i.thinker.org.enity.GmsAuthRule;
import i.thinker.org.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
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
    
    T getByModel(T model);
    
    List<T> getListByModel(T g);
}
