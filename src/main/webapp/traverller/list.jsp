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
    <!--分页css  -->
    <link rel="stylesheet" href="../css/lrtk.css" type="text/css">
    
    <SCRIPT language=javascript>
	function changePage(pageNum){
		
		//将页码的值放入对应隐藏域
		$("#currentPageInput").val(pageNum);
		//提交表单
		$("#pageForm").submit();
	};
	function changeSize(pageSize){
		
		$("#pageSizeInput").val(pageSize);
		$("#pageForm").submit();
	};
	function deleteConfirm(deleteID,deleteName,contextPath){
		if(window.confirm("确认删除"+deleteName+"?")){
			window.location.href="${pageContext.request.contextPath}/TravellerAction_delete?traveller_id="+deleteID;	
		}else{
			return false;
		}
	};
</SCRIPT>
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
                <a class="navbar-brand" href="index.html">COMPANY NAME</a>
            </div>

            <div class="header-right">

                <a href="message-task.html" class="btn btn-info" title="New Message"><b>30 </b><i class="fa fa-envelope-o fa-2x"></i></a>
                <a href="message-task.html" class="btn btn-primary" title="New Task"><b>40 </b><i class="fa fa-bars fa-2x"></i></a>
                <a href="${pageContext.request.contextPath }/UserAction_logout" class="btn btn-danger" title="Logout"><i class="fa fa-exclamation-circle fa-2x"></i></a>

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
                                <a href="${pageContext.request.contextPath }/traverller/add.jsp"><i class="fa fa-toggle-on"></i>  新增旅客信息</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"  ><i class="fa fa-bell "></i>  旅客信息修改</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath }/TraverllerAction_list" class="active-menu"><i class="fa fa-bell "></i>旅客列表</a>
                            </li>
                        </ul>
                    </li>
                      <li>
                        <a href="javascripe:void(0)"><i class="fa fa-anchor "></i>敬请期待</a>
                    </li>
            </div>
        </nav>
        
        <!-- /. 右侧  -->
        <form id="pageForm" action="${pageContext.request.contextPath }/TravellerAction_list" method="post">
        
         <!--隐藏域  -->
        <!--当前页码，每页显示条数  -->
        <input type="hidden" name="currentPage" id="currentPageInput" value="${pageBean.currentPage }">
        <input type="hidden" name="pageSize" id="pageSizeInput" value="${pageBean.pageSize }">
        <div id="page-wrapper">
            <div id="page-inner">
                <!--   Basic Table  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           <div class="form-group row">
                           <div class="col-md-3"style="float:left">
                            <input class="form-control" placeholder="旅客姓名" type="text" name="traveller_name" value="${param.traveller_name }" />
                            </div>
                            <div>
                            <button  class="btn btn-info" type="submit">搜索</button></div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>旅客编号</th>
                                            <th>旅客姓名</th>
                                            <th>身份证号</th>
                                            <th>电话</th>
	                                        <th>房间号</th>
	                                        <th>住房状态</th>
	                                        <th>操作</th>
	                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${pageBean.list }" var="t">
                                        <tr>
                                            <td>${t.traveller_id }</td>
                                            <td>${t.traveller_name }</td>
                                            <td>${t.traveller_cert }</td>
                                            <td>${t.phone }</td>
                                            <td>${t.room.room_number }</td>
                                            <td></td>
                                            <td>
                        <button type="button" class="btn btn-sm btn-info" onclick="window.location.href='${pageContext.request.contextPath }/TravellerAction_toedit?traveller_id=${t.traveller_id }'">修改</button>
                        <button type="button" class="btn btn-sm btn-danger" onclick="deleteConfirm('${t.traveller_id }','${t.traveller_name }')">退房</button></td>
                                        </tr>
                                       </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    
                    <!--分页代码  -->
	<div class="pagnation" id="pagnation">
	<div>共[<b>${pageBean.totalSize }</b>]条记录，[<b>${pageBean.totalPage }</b>]页，每页显示
	<!--使用id选择器传递selected的值  -->
	<select name="pageSizeSelect" onchange="changeSize($('#pageSizeSelect option:selected').val())" id="pageSizeSelect">
	<option value="3"<c:if test="${pageBean.pageSize==3}">selected</c:if>>3</option>
	<option value="5"<c:if test="${pageBean.pageSize==5}">selected</c:if>>5</option>
	</select>
	</div>
	
    <a href="javascript:void(0)" onclick="changePage('${pageBean.currentPage-1}')" target="_blank" class="page-prev"></a>
   
    <!--判断是否为固定页码选择  -->  
    <c:if test="${pageBean.totalPage<=5}">
    <c:forEach varStatus="i"  begin="1" end="${pageBean.totalPage }">
    <a href="javascript:void(0)" <c:if test="${pageBean.currentPage!=i.count}">onclick="changePage(${i.count })"</c:if> target="_blank" <c:if test="${pageBean.currentPage==i.count}">class="current"</c:if>>${i.count}</a>
    </c:forEach>
    </c:if>
     
    <c:if test="${pageBean.totalPage>5}">
   
    <c:if test="${pageBean.currentPage<3 }">
    <c:forEach varStatus="i" begin="1" end="5">
     <a href="javascript:void(0)" <c:if test="${pageBean.currentPage!=i.count}">onclick="changePage(${i.count})"</c:if>  target="_blank" <c:if test="${pageBean.currentPage==i.count}">class="current"</c:if>>${i.count}</a>
    </c:forEach>
    </c:if>
	
	<c:if test="${pageBean.currentPage>=3&&pageBean.currentPage<=pageBean.totalPage-2 }">
    <a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage-2 })" target="_blank">${pageBean.currentPage-2 }</a>
	<a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage-1 })" target="_blank">${pageBean.currentPage-1 }</a>
	<a href="javascript:void(0)"  target="_blank" class="current">${pageBean.currentPage }</a>
	<a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage+1 })" target="_blank">${pageBean.currentPage+1 }</a>
	<a href="javascript:void(0)" onclick="changePage(${pageBean.currentPage+2 })" target="_blank">${pageBean.currentPage+2 }</a>
	</c:if>
	 
	 <c:if test="${pageBean.currentPage>pageBean.totalPage-2 }">
	 <c:forEach varStatus="i" begin="${pageBean.totalPage-4 }" end="${pageBean.totalPage }">
	 <a href="javascript:void(0)" target="_blank" <c:if test="${pageBean.currentPage==pageBean.totalPage-5+i.count }">class="current"</c:if><c:if test="${pageBean.currentPage!=pageBean.totalPage-5+i.count}">onclick="changePage(${pageBean.totalPage-5+i.count })"</c:if> >${pageBean.totalPage-5+i.count}</a>
	 </c:forEach>
   </c:if>

    </c:if>
	<a href="javascript:void(0)" onclick="changePage('${pageBean.currentPage+1}')"target="_blank" class="page-next"></a>
</div>
</form>
<!--分页代码结束  -->	
                   
                      <!-- End  Basic Table  -->
                                <!--INDICATORS-->
                                
                            </div>
                        </div>
                    </div>
                   


                    </div>
                    <!--/.Chat Panel End-->
                </div>
                <!-- /. ROW  -->
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->

    
    <!-- /. FOOTER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${pageContext.request.contextPath }/traverller/assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
       <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>
    


</body>
</html>
