package cn.cqupt.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import cn.cqupt.dao.UserDao;
import cn.cqupt.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getByUserName(final String user_name) {
		
		 return getHibernateTemplate().execute(new HibernateCallback<User>() {

				@Override
				public User doInHibernate(Session session) throws HibernateException {
	                String hql="from User where user_name=?";
	                Query query=session.createQuery(hql);
	                query.setParameter(0, user_name);
					User us = (User) query.uniqueResult();
					return us;
				}
			
	         });
	}

}
