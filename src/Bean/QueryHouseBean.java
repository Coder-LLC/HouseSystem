package Bean;

public class QueryHouseBean implements java.io.Serializable {
    private String title;
    private Double low_price;
    private Double high_price;
    private Double low_floorate;
    private Double high_floorate;
    private int type_id;
    private int street_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String tittle) {
		this.title = tittle;
	}
	public Double getLow_price() {
		return low_price;
	}
	public void setLow_price(Double low_price) {
		this.low_price = low_price;
	}
	public Double getHigh_price() {
		return high_price;
	}
	public void setHigh_price(Double high_price) {
		this.high_price = high_price;
	}
	public Double getLow_floorate() {
		return low_floorate;
	}
	public void setLow_floorate(Double low_floorate) {
		this.low_floorate = low_floorate;
	}
	public Double getHigh_floorate() {
		return high_floorate;
	}
	public void setHigh_floorate(Double high_floorate) {
		this.high_floorate = high_floorate;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getStreet_id() {
		return street_id;
	}
	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}
    
}
