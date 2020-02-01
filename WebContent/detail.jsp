<%@page import="www.jca.com.control.UserControl"%>
<%@page import="www.jca.com.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	
	User user = new User();
	user.setId(id);
	
	UserControl control = new UserControl();
	User item = control.selectOne(user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function moveEditForm(id){
		window.location.replace("/editForm.jsp?id="+id);
	}
	function deleteThis(id){
		window.location.replace("/delete/user?id="+id);
	}
</script>
</head>
<body>
	<table>
		<colgroup>
			<col width="25%">
			<col width="75%">
		</colgroup>
		<tbody>
			<tr>
				<th>id
				</th>
				<td><%=item.getId() %>
				</td>
			<tr>
			<tr>
				<th>username
				</th>
				<td><%=item.getUsername() %>
				</td>
			<tr>
			<tr>
				<th>phone
				</th>
				<td><%=item.getPhone() %>
				</td>
			<tr>
		</tbody>
	</table>
	<input type="button" value="수정" onclick="javascript:moveEditForm(<%=item.getId()%>);">
	<input type="button" value="삭제" onclick="javascript:deleteThis(<%=item.getId()%>);">
</body>
</html>