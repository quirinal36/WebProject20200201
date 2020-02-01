package www.jca.com.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.jca.com.User;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/edit/user")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String userName = request.getParameter("username");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setId(id);
		user.setUsername(userName);
		user.setPhone(phone);
		user.setPassword(password);
		
		UserControl control = new UserControl();
		int result = control.update(user);
		
		if(result > 0) {
			response.sendRedirect("/userList.jsp");
		}
	}

}
