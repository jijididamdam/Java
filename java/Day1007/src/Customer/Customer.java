package Customer;

public class Customer {
	
	String cid = null;
	String cname = null;
	String cpw = null;


	
	void cprt() {
		System.out.println("고객아이디 : "+cid);
		System.out.println("고객이름 : "+cname);
		System.out.println("고객비밀번호 : "+cpw);
	}
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpw() {
		return cpw;
	}
	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

}
