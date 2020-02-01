<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="www.jca.com.db.DBConn"%>
<%@page import="java.util.ArrayList"%>
<%@page import="www.jca.com.User"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<User> list = new ArrayList<User>();			// 저장할 장소 (지금은 텅텅 비어있음)

DBConn db = new DBConn();							// 데이터베이스 접속을 도와주는 객체

try (Connection connection = db.getConnection()){		// connection : 자바와 DB 연결
	String sql = new StringBuilder()
					.append("SELECT * ")
					.append("FROM users")
					.toString();					// 쿼리문 작성

	PreparedStatement pstmt = connection.prepareStatement(sql);		// DB 일처리 위한 객체 sql 쿼리문 전달
	
	ResultSet rs = pstmt.executeQuery();			// 쿼리문 실제 실행
	while(rs.next()){
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setUsername(rs.getString("username"));
		user.setPhone(rs.getString("phone"));
		
		list.add(user);
	}
} catch (ClassNotFoundException e) {
	e.printStackTrace();
} catch (SQLException e1) {
	e1.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 리스트</title>
</head>
<body>
	<table>
		<colgroup>
			<col width="15%">
			<col width="50%">
			<col width="35%">
		</colgroup>
		<thead>
			<tr>
				<th>id</th>
				<th>username</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0; i<list.size(); i++){
				User item = list.get(i);
			%>
			<tr>
				<td><%=item.getId() %></td>
				<td>
					<a href="./detail.jsp?id=<%=item.getId() %>">
						<%=item.getUsername() %>
					</a>
				</td>
				<td><%=item.getPhone() %></td>
			</tr>
			
			<%} %>
		</tbody>
	</table>
</body>
</html>