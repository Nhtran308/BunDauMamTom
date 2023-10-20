package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogInServlet")

public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogInServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,

			HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ")

				.append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn;
		try {
			conn = MySQL.getMySQLConnection();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserAccount usr = new UserAccount(username, password);
			UserAccount u = DBU.findUser(conn, usr.getUserName(), usr.getPassword());

			if (u != null) {
				UserAccount user = new UserAccount(u);
				javax.servlet.http.HttpSession session = request.getSession();
				session.setAttribute("acc", user);
				request.getRequestDispatcher("Show").forward(request, response);
			} else {
				request.setAttribute("mess", "Nhập sai tài khoản hoặc mật khẩu");
				request.getRequestDispatcher("/LogIn.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, e);
		} catch (SQLException e) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}