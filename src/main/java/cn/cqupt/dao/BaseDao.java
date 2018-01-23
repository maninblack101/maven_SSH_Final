package cn.cqupt.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {

	//增或更新
	void saveOrUpdate(T t);
	//增
	void save(T t);
	//删(根据对象删)
	void delete(T t);
	//删（根据id删）
	void delete(Serializable id);
	//改
	void update(T t);
	//查(根据id查)
	T  getById(Serializable id);
	//查(根据离线查询对象查询总记录数)
	Integer getTotalCount(DetachedCriteria dc);
	//查(分页查询)
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
}
