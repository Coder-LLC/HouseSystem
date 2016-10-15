package Bean;

import java.util.HashSet;
import java.util.Set;

public class DistrictBean implements java.io.Serializable {
    private int id;
    private String name;
    private Set streets=new HashSet();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getStreets() {
		return streets;
	}
	public void setStreets(Set streets) {
		this.streets = streets;
	}
    
}
