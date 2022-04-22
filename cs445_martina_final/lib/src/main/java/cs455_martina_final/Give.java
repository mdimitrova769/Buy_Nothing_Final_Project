package cs455_martina_final;

import java.util.ArrayList;
import java.util.UUID;

public class Give {
	
	 private String uid; 
	private String gid ; 
	 private String type; 
	 private String description;
	 private String start_date; 
	private String  end_date; 
	private ArrayList<String> extra_zip; 
	private boolean is_active;
	private String date_created;
	
	public Give(Give give) {
		super();
		this.uid = give.getUid();
		this.gid = UUID.randomUUID().toString();
		switch(give.getType()) {
		  case "gift":
			  this.setType(give.getType());
			  break;
		  case "service":
			  this.setType(give.getType());
		    break;
		  case "lend":
			  this.setType(give.getType());
			    break;
		  case "share":
			  this.setType(give.getType());
			    break;
		  default:
			  this.type = " ";
		}
		this.description = give.getDescription();
		this.start_date = give.getStart_date();
		this.end_date = give.getEnd_date();
		this.extra_zip = give.getExtra_zip();
		this.is_active = true;
		this.date_created = "2022-05-13T17:56:13Z";
	} 
	
	public Give(String uid, String gid, String type, String description, String start_date, String end_date,
			ArrayList<String> extra_zip, boolean is_active, String date_created) {
		super();
		this.uid = uid;
		this.gid = UUID.randomUUID().toString();
		switch(type) {
		  case "gift":
			  this.type = type;
			  break;
		  case "service":
		    this.type = type;
		    break;
		  case "lend":
			    this.type = type;
			    break;
		  case "share":
			    this.type = type;
			    break;
		  default:
			  this.type = " ";
		}
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
		this.extra_zip = extra_zip;
		this.is_active = true;
		this.date_created = "2022-05-13T17:56:13Z";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGid() {
		return gid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public ArrayList<String> getExtra_zip() {
		return extra_zip;
	}

	public void setExtra_zip(ArrayList<String> extra_zip) {
		this.extra_zip = extra_zip;
	}
	
	public String getDate_created() {
		return date_created;
	}
	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	} 
	
	public String getType() {
		return type;
	}
	
	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setType(String type) {
		this.type = type;
	} 
	
	public boolean matchesId(String gid1) {
        return(gid1.equals(this.gid));
}
	

}
