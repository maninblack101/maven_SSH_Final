package cn.cqupt.action;

import cn.cqupt.entity.User;
import cn.cqupt.service.SupplierService;
import cn.cqupt.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user=new User();
	 private UserService us;
	
	

	public String login() throws Exception {
		//调用service层方法
		User u = us.getUserByNamepassword(user);
        ActionContext.getContext().getSession().put("user", u);
		return "tohome";
	}
	
	public String logout() throws Exception{
		ActionContext.getContext().getSession().remove("user");
		return "tohome";
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUs(UserService us) {
		this.us = us;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	
}
