package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Show() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<Product> list = new ArrayList<Product>();
		List<Product> listMe = new ArrayList<Product>();
		try {
			Connection conn = MySQL.getMySQLConnection();
			list = DBU.ShowProduct(conn);
			listMe = DBU.ShowProduct(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListP", list);
		request.setAttribute("ListM", listMe);
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
		
	}
}
