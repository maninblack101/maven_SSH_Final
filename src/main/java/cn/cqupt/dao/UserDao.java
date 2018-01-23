package cn.cqupt.dao;

import cn.cqupt.entity.User;

public interface UserDao extends BaseDao<User> {

	User getByUserName(String user_name);

	
}
