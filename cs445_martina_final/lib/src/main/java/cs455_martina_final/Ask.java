package cs455_martina_final;

import java.util.ArrayList;
import java.util.UUID;

public class Ask {
	
	 private String uid; 
	 private String aid;
	 private String type;
	 private String description; 
	 private String start_date; 
	 private String end_date; 
	 private ArrayList<String> extra_zip; 
	 private boolean is_active; 
	 private String date_created;
	 
	 public Ask () {
			super();
			this.uid = "null";
			this.aid = UUID.randomUUID().toString();
			this.type = null;
			this.description = null;
			this.start_date = null;
			this.end_date = null;
			this.extra_zip = null;
			this.is_active = false;
			this.date_created = "2022-03-13T17:56:13Z";
		}
	 
	public Ask (Ask ask) {
		super();
		this.uid = ask.getUid();
		this.aid = UUID.randomUUID().toString();
		switch(ask.getType()) {
		  case "gift":
			  this.setType(ask.getType());
			  break;
		  case "borrow":
			  this.setType(ask.getType());
		    break;
		  case "help":
			  this.setType(ask.getType());
			    break;
		  default:
			  this.type = " ";
		}
		this.description = ask.getDescription();
		this.start_date = ask.getStart_date();
		this.end_date = ask.getEnd_date();
		this.extra_zip = ask.getExtra_zip();
		this.is_active = ask.getIs_active();
		this.date_created = "2022-03-13T17:56:13Z";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
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

	public boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getDate_created() {
		return date_created;
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
		switch(type) {
		  case "gift":
			  this.type = type;
			  break;
		  case "borrow":
		    this.type = type;
		    break;
		  case "help":
			    this.type = type;
			    break;
		  default:
			  this.type = " ";
		}
	} 
	
	public boolean matchesId(String aid1) {
        return(aid1.equals(this.aid));
}
	
	
	 
	 
}
