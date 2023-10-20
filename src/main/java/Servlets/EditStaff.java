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

@WebServlet("/EditStaff")
public class EditStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStaff() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			conn = MySQL.getMySQLConnection();
			
            String manage = request.getParameter("manage");
            String name = request.getParameter("name");
            String role = request.getParameter("role");
            String idstaff = request.getParameter("idStaff");
            
            Staff staff = new Staff(idstaff, manage, name, role);
			DBU.EditStaff(conn, staff);
			System.out.print(staff);
			request.getRequestDispatcher("StaffServlet").forward(request, response);

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}
		doGet(request, response);
	}
    	 
  
}
