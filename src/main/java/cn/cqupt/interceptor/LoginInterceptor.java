package cn.cqupt.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		       //获得session
				Map<String, Object> session = ActionContext.getContext().getSession();
				//获得登录标识
				Object obj = session.get("user");
				//不存在，没登陆，重定向到login.jsp
				if(obj==null){
					return "toLogin";
				}else{
					//存在，放行
					return invocation.invoke();
				}
	}

}
