package cs455_martina_final;

public class Otgovor {
	
	private String type;
	private String title;
	private String detail;
	private int status;
	private String instance;
	
	public Otgovor() {
		super();
		this.type = null;
		this.title = null;
		this.detail = null;
		this.status = 0;
		this.instance = null;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getInstance() {
		return instance;
	}
	public void setInstance(String instance) {
		this.instance = instance;
	}
	
	
	
	

}
