<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <title>用户登录</title>
    <style>body{padding-top: 0px;}</style>
	
   

   

</head>
<body>
<div  style="background-color: #E2E2E2;">
  <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">使用第三方登录</h4>
                    </div>
                    <div class="modal-body">  
                        <div class="box">
                             <div class="content">
                                <div class="social">
                                   
                                    <a id="wechat_login" class="circle github" href="/auth/google_oauth2">
                                        <i class="fa fa-weixin" aria-hidden="true"></i>
                                    </a>
                                    <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                        <i class="fa fa-qq" aria-hidden="true"></i>
                                    </a>
                                </div>
                                <div class="division">
                                    <div class="line l"></div>
                                     <span>or</span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="${pageContext.request.contextPath }/UserAction_login"  accept-charset="UTF-8">
                                    <input id="user_name" class="form-control" type="text" placeholder="账号" name="user_name">
                                    <input id="user_password" class="form-control" type="password" placeholder="密码" name="user_password">
                                    <input class="btn btn-default btn-login" type="submit" value="登录" >
                                    <font color="red"><s:property value="exception.message"></s:property></font>
                                    <!--onclick="loginAjax()"  -->
                                    </form>
                                </div>
                             </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form">
                                <form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
                                <input id="email" class="form-control" type="text" placeholder="账号" name="email">
                                <input id="password" class="form-control" type="password" placeholder="密码" name="password">
                                <input id="password_confirmation" class="form-control" type="password" placeholder="确认密码" name="password_confirmation">
                                <input class="btn btn-default btn-register" type="submit" value="创建" name="commit">
                                </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span> 
                                 <a href="javascript: showRegisterForm();">创建一个新账户</a>
                            ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>已有账号?</span>
                             <a href="javascript: showLoginForm();">登录</a>
                        </div>
                    </div>        
    		      </div>
		      </div>
		  </div> 
       </div>        
                
    
</body>
</html>
