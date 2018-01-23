package cn.cqupt.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.cqupt.dao.BaseDao;

public class BaseDaoImpl<T>extends HibernateDaoSupport implements BaseDao<T> {

	//获得运行时期泛型
	private Class clazz;
	
	public BaseDaoImpl(){
		//获得当前类型的带有泛型类型的父类
		//parameterizedType参数化类型
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得类型（即运行时期的类型）
		//返回的是数组(可能会传入多个泛型)	
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
		T t=this.getById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		 
		return (T) getHibernateTemplate().get(clazz,id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		//设置聚合函数
		dc.setProjection(Projections.rowCount());
		
		List<Long>list=(List<Long>) getHibernateTemplate().findByCriteria(dc);
		//清空聚合函数
		dc.setProjection(null);
		
		if(list!=null&&list.size()>0){
			Long count = list.get(0);
			return count.intValue();
		}else{
		return null;
	    }
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start,Integer pageSize) {
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc,start,pageSize);
		return list;
	}

	@Override
	public void saveOrUpdate(T t) {
         getHibernateTemplate().saveOrUpdate(t);		
	}

}
