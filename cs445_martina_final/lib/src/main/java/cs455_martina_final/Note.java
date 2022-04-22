package cs455_martina_final;

import java.util.UUID;

public class Note {
	private String uid;
    private String nid;
    private String to_type;
    private String to_user_id;
  	private String to_id;
    private String description;
    private String date_created;
    
    public Note(Note note) {
		super();
		this.uid = note.getUid();
		this.nid = UUID.randomUUID().toString();
		switch(note.getTo_type()) {
		  case "ask":
			  this.setTo_type(note.getTo_type());
			  break;
		  case "give":
			  this.setTo_type(note.getTo_type());
		    break;
		  case "note":
			  this.setTo_type(note.getTo_type());
			    break;
		  default:
			  this.to_type = " ";
		}
		this.to_user_id = note.getTo_user_id();
		this.to_id = note.getTo_id();
		this.description = note.getDescription();
		this.date_created = "2022-05-13T17:56:13Z";
	}
    
	public Note() {
		super();
		this.uid = null;
		this.nid = UUID.randomUUID().toString();
		this.to_type = null;
		this.to_user_id = null;
		this.to_id = null;
		this.description = null;
		this.date_created = "2022-05-13T17:56:13Z";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getTo_type() {
		return to_type;
	}

	public void setTo_type(String to_type) {
		switch(to_type) {
		  case "ask":
			  this.to_type = to_type;
			  break;
		  case "give":
			  this.to_type = to_type;
		    break;
		  case "note":
			  this.to_type = to_type;
			    break;
		  default:
			  this.to_type = " ";
		}
	}

	public String getTo_user_id() {
		return to_user_id;
	}

	public void setTo_user_id(String to_user_id) {
		this.to_user_id = to_user_id;
	}

	public String getTo_id() {
		return to_id;
	}

	public void setTo_id(String to_id) {
		this.to_id = to_id;
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
