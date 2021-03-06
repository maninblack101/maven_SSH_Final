<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>home</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="../assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="../assets/css/font-awesome.css" rel="stylesheet" />
       <!--CUSTOM BASIC STYLES-->
    <link href="../assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="../assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">酒店管理系统</a>
            </div>

            <div class="header-right">

                 <!--未登录显示  -->
                <c:if test="${user!=null }">
                <a href="message-task.html" class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>
                <a href="message-task.html" class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>
                <a href="${pageContext.request.contextPath }/UserAction_logout" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>
                </c:if>
                
                <!--登录显示  -->
                <c:if test="${user==null }">
                <button class="btn btn-lg btn-primary" onclick="openLoginModal();"><b>登录</b><i class="fa fa-user" aria-hidden="true"></i></button>
                <button class="btn btn-lg btn-info" onclick="openRegisterModal();"><b>注册</b><i class="fa fa-circle-o" aria-hidden="true"></i></button>                
                </c:if>
            </div>
        </nav>
        <!-- /. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <div class="user-img-div">
                            <img src="../assets/img/user.png" class="img-thumbnail" />

                            <div class="inner-text">
                                
                            <br />
                                                 <strong>
           <c:if test="${user!=null }">                   
                                管理员${user.user_name }
            </c:if>     </strong>
           <strong>
            <c:if test="${user==null }">
                                请登录!
            </c:if>                
                     </strong>  
                            </div>
                        </div>

                    </li>


                    <li>
                        <a class="active-menu" href="index.html"><i class="fa fa-dashboard "></i>管理中心</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop ">  房间管理</i> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="${pageContext.request.contextPath }/room/add.jsp"><i class="fa fa-toggle-on"></i>  新增房间</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"  ><i class="fa fa-bell "></i>  房间信息修改</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath }/RoomAction_list"><i class="fa fa-bell "></i>房间列表</a>
                            </li>
                        </ul>
                    </li>
                      <li class="active">
                        <a href="#"><i class="fa fa-desktop ">  旅客管理</i> <span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="javascript:void(0)" class="active-menu"><i class="fa fa-toggle-on"></i>  新增旅客信息</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"  ><i class="fa fa-bell "></i>  旅客信息修改</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath }/TravellerAction_list"><i class="fa fa-bell "></i>旅客列表</a>
                            </li>
                        </ul>
                    </li>
                     
                      <li>
                        <a href="javascripe:void(0)"><i class="fa fa-anchor "></i>敬请期待</a>
                    </li>
            </div>
        </nav>
        
        <!-- /. 右侧  -->
        <div id="page-wrapper">
            <div id="page-inner">
                         <div class="panel-heading">
                   <s:property value="#traveller==null?'新建':'修改'"/>房间信息
                        </div>
                        <div class="panel-body">
                            <form role="form" action="${pageContext.request.contextPath }/TravellerAction_add" method="post">
                                        <div class="form-group">
                                            <label>旅客姓名</label>
                                            <input class="form-control" type="text" name="traveller_name" value="${traveller.traveller_name }">
                                            <p class="help-block">Help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>身份证号码</label>
                                            <input class="form-control" type="text" name="traveller_cert" value="${traveller.traveller_cert }">
                                            <p class="help-block">Help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>电话号码</label>
                                            <input class="form-control" type="text" name="phone" value="${traveller.phone }">
                                            <p class="help-block">Help text here.</p>
                                        </div>
                                        <div class="form-group">
                                            <label>e-mail</label>
                                            <input class="form-control" type="text" name="email" value="${traveller.email }">
                                            <p class="help-block">Help text here.</p>
                                        </div>
                                        
                                    <hr>
                                     <div class="form-group">
                                            <label>入住日期</label>
                                            <input class="form-control" type="text" name="order_time" value="${traveller.order_time }">
                                     <p class="help-block">Help text here.</p>
                                        </div>
                                         <div class="form-group">
                                            <label>入住天数</label>
                                            <input class="form-control" type="text" name="limited_day" value="${traveller.limited_day }">
                                     <p class="help-block">Help text here.</p>
                                           </div>
                                     <hr>    
                                         <div class="form-group">
                                            <label>入住房间</label>
                                            <input class="form-control" type="text" name="room_id" value="${traveller.room.room_number }">
                                     <p class="help-block">Help text here.</p>
                                           </div>
                                       
                                       
                                       </div>
                           
                                        <button type="submit" class="btn btn-info">提交 </button>

                                    </form>
                            </div>
                               
                                
                            </div>
                        </div>
                    </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    <s:debug></s:debug>
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
       <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    


</body>
</html>
