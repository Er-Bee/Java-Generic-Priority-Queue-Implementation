
public class CustomerTicket {
	private String name;
	private String ticket;
	private int id;
	
	public CustomerTicket(String name, String ticket, int id) {
		this.name = name;
		this.ticket = ticket;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getTicket() {
		return ticket;
	}

	public int getId() {
		return id;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof CustomerTicket))
			return false;
		return ((CustomerTicket)obj).getId() == this.getId() && ((CustomerTicket)obj).ticket == this.getTicket();
	}
	
}
