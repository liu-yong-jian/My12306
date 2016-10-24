package at.danicoz.user.po;

public class CertType {

	private Integer id;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CertType [id=" + id + ", content=" + content + "]";
	}
	
	
}
