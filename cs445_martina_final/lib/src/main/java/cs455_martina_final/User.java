package cs455_martina_final;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class User {
	
	private String uid;
	private String name;
	private Address address = new Address();
	private String picture;
	private Boolean is_active;
	private String phone; 
	private String date_created;
	
	private ArrayList<Ask> asks = new ArrayList<Ask>(); 
	private ArrayList<Give> gives = new ArrayList<Give>(); 
	private ArrayList<Thank> thanks = new ArrayList<Thank>(); 
	private ArrayList<Note> notes = new ArrayList<Note>(); 
	
	public User() {

		this.uid = UUID.randomUUID().toString();
		this.name = null;
		this.address = new Address ();
		this.picture = null;
		this.is_active = false;
		this.phone = null; 
		this.date_created = "2022-03-13T17:56:13Z";
	}
	
	
	public User( String name, String street, String zip, String picture, String phone, Boolean is_active, String date) {
		this.uid = UUID.randomUUID().toString();
		this.name = name;
		this.address.setStreet(street);
		this.address.setZip(zip);
		this.picture = picture;
		this.is_active = is_active;
		this.phone = phone;
		this.date_created = date;
	}



	public User(User user) {
		
		this.uid = UUID.randomUUID().toString();
		this.name = user.getName();
		this.address = new Address (user.getAddress());
		this.picture = user.getPicture();
		this.is_active = false;
		this.phone = user.getPhone();
		
		this.date_created = "2022-03-13T17:56:13Z";
	}
	
	
	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}
	
	public Boolean getIs_active() {
		return is_active;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address1) {
		this.address.setStreet(address1.getStreet());
		this.address.setZip(address1.getZip());
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = UUID.randomUUID().toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public boolean matchesId(String lid) {
	        return(lid.equals(this.uid));
	}

	public boolean isNil() {
		// TODO Auto-generated method stub
		return false;
	}

	public void addAsk(Ask ask) {
		asks.add(ask);
	}
	
	public void addGive(Give give) {
		gives.add(give);
	}
	
	public void addThank(Thank thank) {
		thanks.add(thank);
	}
	
	public void addNote(Note note) {
		notes.add(note);
	}
	
	public ArrayList<Ask> getAsks(){
		return asks;
	}


	@Override
	public String toString() {
		return " name= " + this.getName() + " , address= " + this.getAddress().toString() + ", phone= " + this.getPhone() ;
	}



	public ArrayList<Give> getGives() {
		return gives;
	}
	
	public ArrayList<Thank> getThanks() {
		return thanks;
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}

}
