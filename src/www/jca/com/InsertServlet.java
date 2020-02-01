package www.jca.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.jca.com.db.DBConn;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert/user")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(userName);
		user.setPhone(phone);
		user.setPassword(password);


		DBConn db = new DBConn();
		
		try (Connection connection = db.getConnection()){
			String sql = new StringBuilder().append("INSERT INTO users ")
					.append("(username, phone, password) VALUES (?,?,?)")
					.toString();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getPassword());
			
			int result = pstmt.executeUpdate();
			response.getOutputStream().print("result: " + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
