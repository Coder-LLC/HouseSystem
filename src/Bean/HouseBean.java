package Bean;

import java.util.Date;

public class HouseBean implements java.io.Serializable {
    private int id;
    private int type_id;
    private int user_id;
    private int street_id;
    private String title;
    private String description;
    private Date date;
    private Double price;
    private String contact;
    private Double floorate;
    private UserBean user;
    private TypeBean type;
    private StreetBean street;
    //private Date house_date;
   // private Point point;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getStreet_id() {
		return street_id;
	}
	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Double getFloorate() {
		return floorate;
	}
	public void setFloorate(Double floorate) {
		this.floorate = floorate;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public TypeBean getType() {
		return type;
	}
	public void setType(TypeBean type) {
		this.type = type;
	}
	public StreetBean getStreet() {
		return street;
	}
	public void setStreet(StreetBean street) {
		this.street = street;
	}
	/*public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	*/
	/*public Date getHouse_date() {
		return house_date;
	}
	public void setHouse_date(Date house_date) {
		this.house_date = house_date;
	}*/
    
}
