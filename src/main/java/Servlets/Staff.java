package Servlets;

public class Staff {
	private String IdStaff;
	private String Manage;
	private String Name;
	private String Role;
	
	public Staff(String IdStaff, String Manage, String Name, String Role) {
		this.IdStaff = IdStaff;
		this.Manage = Manage;
		this.Name = Name;
		this.Role = Role;
	}
	
	public Staff () {
		
	}
	public String getIdStaff() {
		return IdStaff;
	}
	public void setIdStaff(String idStaff) {
		IdStaff = idStaff;
	}
	public String getManage() {
		return Manage;
	}
	public void setManage(String manage) {
		Manage = manage;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "Staff [IdStaff=" + IdStaff + ", Manage=" + Manage + ", Name=" + Name + ", Role=" + Role + "]";
	}
	
	
}