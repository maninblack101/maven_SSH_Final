package cn.cqupt.serviceImpl;

import cn.cqupt.dao.UserDao;
import cn.cqupt.entity.User;
import cn.cqupt.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao ud;
	
	@Override
	public User getUserByNamepassword(User user) {
		//1.根据登录名称查询对象
        User existU = ud.getByUserName(user.getUser_name()); 
		//2.判断是否有存在的对象
        if(existU==null){
        	throw new RuntimeException("用户名错误");
        }
	    if(!existU.getUser_password().equals(user.getUser_password())){
	    	throw new RuntimeException("密码错误");    	
	    }
		//存在，获取用户
		return existU;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
}
