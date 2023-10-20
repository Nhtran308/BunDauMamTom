package Servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class DBU {
	public static void insertUserAccount(Connection conn, UserAccount user) throws SQLException {
		String sql = "Insert into UserAccount(Username, Gender, Password) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getUserName());
		pstm.setString(2, user.getGender());
		pstm.setString(3, user.getPassword());

		pstm.executeUpdate();
	}

	public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

		String sql = "Select a.Username, a.Password, a.Gender from UserAccount a "
				+ " where a.Username = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;

	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.Username, a.Password, a.Gender from UserAccount a "//

				+ " where a.Username = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> ShowProduct(Connection conn) throws SQLException {
		String sql = "SELECT * FROM `product` ORDER BY `product`.`Id` ASC";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String id = rs.getString("Id");
			String image = rs.getString("Image");
			String name = rs.getString("Name");
			String type = rs.getString("Type");
			int price = rs.getInt("Price");
			Product product = new Product();
			product.setId(id);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setType(type);
			list.add(product);
		}
		return list;
	}
	public static List<Product> Menu(Connection conn, String Type) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM `product` WHERE type = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Type);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String id = rs.getString("Id");
			String image = rs.getString("Image");
			String name = rs.getString("Name");
			String type = rs.getString("Type");
			int price = rs.getInt("Price");
			Product product = new Product();
			product.setId(id);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setType(type);
			list.add(product);
		}
		return list;
	}
	
	public static List<Product> Search(Connection conn, String txtSearch) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT * FROM `product` WHERE name like ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, "%"+txtSearch+"%");
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String id = rs.getString("Id");
			String image = rs.getString("Image");
			String name = rs.getString("Name");
			String type = rs.getString("Type");
			int price = rs.getInt("Price");
			Product product = new Product();
			product.setId(id);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setType(type);
			list.add(product);
		}
		return list;
	}
	
	public static Product LoadProduct(Connection conn, String Id) throws SQLException {
		String sql = "SELECT * FROM product WHERE id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Id);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String id = rs.getString("Id");
			String image = rs.getString("Image");
			String name = rs.getString("Name");
			String type = rs.getString("Type");
			int price = rs.getInt("Price");
			Product product = new Product();
			product.setId(id);
			product.setImage(image);
			product.setName(name);
			product.setPrice(price);
			product.setType(type);
			return product;
		}
		return null;
	}

	public static void DeleteProduct(Connection conn, String Id) throws SQLException {
		String sql = "DELETE FROM product WHERE id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Id);
		pstm.executeUpdate();
	}

	public static void AddProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into product(Id, Image, Name, Type, Price) values (?,?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getId());
		pstm.setString(2, product.getImage());
		pstm.setString(3, product.getName());
		pstm.setString(4, product.getType());
		pstm.setInt(5, product.getPrice());

		pstm.executeUpdate();
	}

	public static void EditProduct(Connection conn, Product product) throws SQLException {
		String sql = "UPDATE product set Image= ?, Name = ?, Type = ?, Price = ? where Id= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getImage());
		pstm.setString(2, product.getName());
		pstm.setString(3, product.getType());
		pstm.setInt(4, product.getPrice());
		pstm.setString(5, product.getId());
		pstm.executeUpdate();
	}
	
	public static Staff LoadStaff(Connection conn, String IdStaff) throws SQLException {
		String sql = "SELECT * FROM staff WHERE IdStaff = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, IdStaff);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			String idstaff = rs.getString("IdStaff");
			String manage = rs.getString("Manage");
			String name = rs.getString("Name");
			String role = rs.getString("Role");
			Staff staff = new Staff();
			staff.setIdStaff(idstaff);
			staff.setManage(manage);
			staff.setName(name);
			staff.setRole(role);
			return staff;
		}
		return null;
	}
	public static List<Staff> ShowStaff(Connection conn) throws SQLException {
		String sql = "SELECT * FROM `staff` ORDER BY `staff`.`IdStaff` ASC";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Staff> list = new ArrayList<Staff>();
		while (rs.next()) {
			String idstaff = rs.getString("IdStaff");
			String manage = rs.getString("Manage");
			String name = rs.getString("Name");
			String role = rs.getString("Role");
			Staff staff = new Staff();
			staff.setIdStaff(idstaff);
			staff.setManage(manage);
			staff.setName(name);
			staff.setRole(role);
			list.add(staff);
		}
		return list;
	}
	public static void DeleteStaff(Connection conn, String idStaff) throws SQLException {
		String sql = "DELETE FROM staff WHERE idstaff = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, idStaff);
		pstm.executeUpdate();
	}

	public static void AddStaff(Connection conn, Staff staff) throws SQLException {
		String sql = "Insert into staff(IdStaff, Manage, Name, Role) values (?,?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, staff.getIdStaff());
		pstm.setString(2, staff.getManage());
		pstm.setString(3, staff.getName());
		pstm.setString(4, staff.getRole());
		
		pstm.executeUpdate();
	}

	public static void EditStaff(Connection conn, Staff staff) throws SQLException {
		String sql = "UPDATE staff set Manage= ?, Name = ?, Role = ? where IdStaff= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, staff.getManage());
		pstm.setString(2, staff.getName());
		pstm.setString(3, staff.getRole());
		pstm.setString(4, staff.getIdStaff());
		pstm.executeUpdate();
	}
}
