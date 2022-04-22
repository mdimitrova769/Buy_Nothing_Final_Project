package cs455_martina_final;

import java.util.UUID;

public class Report {
	
	private String rid;
    private String name;
	
    public Report() {
		super();
		this.rid = UUID.randomUUID().toString();
		this.name = null;
	}
    
    public Report(String name) {
		super();
		this.rid = UUID.randomUUID().toString();
		this.name = name;
	}
    
    public Report(Report report) {
		super();
		this.rid = UUID.randomUUID().toString();
		this.name = report.getName();
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
