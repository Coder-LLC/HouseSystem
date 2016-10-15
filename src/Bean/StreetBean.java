package Bean;

public class StreetBean implements java.io.Serializable {
    private int id;
    private int district_id;
    private String name;
    private DistrictBean district;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DistrictBean getDistrict() {
		return district;
	}
	public void setDistrict(DistrictBean district) {
		this.district = district;
	}
    
}
