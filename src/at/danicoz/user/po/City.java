package at.danicoz.user.po;

public class City {

	private Integer id;
	private String cityId;
	private Province province;
	private String city;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "City [id=" + id + ", cityId=" + cityId + ", province="
				+ province + ", city=" + city + "]";
	}
	
	
}
