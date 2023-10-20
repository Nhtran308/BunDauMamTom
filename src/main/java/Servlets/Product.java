package Servlets;

public class Product {
	private String Id;
	private String Image;
	private String Name;
	private String Type;
	private int Price;
	
	public Product(String Image, String Name, String Type, int Price) {
		this.Image = Image;
		this.Name = Name;
		this.Type = Type;
		this.Price = Price;
	}
	public Product(String Id, String Image, String Name, String Type, int Price) {
		this.Id = Id;
		this.Image = Image;
		this.Name = Name;
		this.Type = Type;
		this.Price = Price;
	}
	public Product() {
		
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Image=" + Image + ", Name=" + Name + ", Type=" + Type + ", Price=" + Price
				+ "]";
	}
}
