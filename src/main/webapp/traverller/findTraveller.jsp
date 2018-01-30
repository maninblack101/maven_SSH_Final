<%@ page language="java" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>旅客信息</title>
</head>
<body>
  <table class="table">
                                    <thead>
                                        <tr>
                                            <th>旅客编号</th>
                                            <th>旅客姓名</th>
                                            <th>身份证号</th>
                                            <th>电话</th>
	                                        <th>房间号</th>
	                                        <td>操作</td>
	                                        </tr>
                                    </thead>
                                    <tbody>
                                     
                                        <tr>
                                            <td>${travller.traveller_id }</td>
                                            <td>${travller.traveller_name }</td>
                                            <td>${travller.traveller_cert }</td>
                                            <td>${travller.phone }</td>
                                            <td>${travller.room.room_number }</td>
                                            <td>
                        <button type="button" class="btn btn-sm btn-info" onclick="window.location.href='${pageContext.request.contextPath }/TravellerAction_toedit?traveller_id=${travller.traveller_id }'">修改</button>
                        <button type="button" class="btn btn-sm btn-danger" onclick="deleteConfirm('${travller.traveller_id }','${travller.traveller_name }')">退房</button></td>
                                        </tr>
                                       
                                        
                                    </tbody>
                                </table>
</body>
</html>