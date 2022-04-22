package cs455_martina_final;

public class Address {
	
	private String street;
	private String zip;
	
	
	public Address() {
		super();
		this.street = "";
		this.zip = "";
	}
	
	public Address(Address address1) {
		super();
		this.street = address1.getStreet();
		this.zip = address1.getZip();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return " street= " + this.getStreet() + " , zip= " + this.getZip();
	}
	

}
