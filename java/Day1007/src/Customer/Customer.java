package Customer;

public class Customer {
	
	String cid = null;
	String cname = null;
	String cpw = null;


	
	void cprt() {
		System.out.println("�����̵� : "+cid);
		System.out.println("���̸� : "+cname);
		System.out.println("����й�ȣ : "+cpw);
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
