package cs455_martina_final;

import java.util.UUID;

public class Thank {
	
	 private String uid;
    private String tid;
  	private String thank_to;
    private String description;
    private String date_created;
    
    public Thank() {
		super();
		this.uid = null;
		this.tid = UUID.randomUUID().toString();
		this.thank_to = null;
		this.description = null;
		this.date_created = "2022-05-13T17:56:13Z";
	}
    
    public Thank(Thank thank) {
		super();
		this.uid = thank.getUid();
		this.tid = UUID.randomUUID().toString();
		this.thank_to = thank.getThank_to();
		this.description = thank.getDescription();
		this.date_created = "2022-05-13T17:56:13Z";
	}
    
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getThank_to() {
		return thank_to;
	}

	public void setThank_to(String thank_to) {
		this.thank_to = thank_to;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
    
    

}
