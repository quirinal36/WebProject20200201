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
<title>회원정보입력</title>
</head>
<body>
	<form method="POST" action="/edit/user">
	<table>
		<colgroup>
			<col width="25%">
			<col width="50%">
		</colgroup>
		<tbody>
			<tr>
				<th>이름</th>
				<td>
					<input name="username" type="text" placeholder="이름을 입력하세요." value="<%=item.getUsername() %>"/>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input name="password" type="password" placeholder="비밀번호를 입력하세요." value="<%=item.getPassword() %>"/>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input name="phone" type="text" placeholder="전화번호를 입력하세요." value="<%=item.getPhone() %>"/>
				</td>
			</tr>
		</tbody>
	</table>
	<input type="hidden" name="id" value="<%=item.getId()%>">
	
	<input type="submit">
	</form>
</body>
</html>