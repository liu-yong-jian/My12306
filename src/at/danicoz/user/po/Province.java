package at.danicoz.user.po;

public class Province {

	private Integer id;
	private String provinceId;
	private String province;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceId=" + provinceId
				+ ", province=" + province + "]";
	}
	
	
}
