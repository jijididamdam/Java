package Stock;

public class Stock {
	String sid=null;
	String sname=null;
	int scnt = 0;
	int sprice = 0;
	String pname=null;
	String date=null;
	
	public void sprt() {
		System.out.println("������ ���̵� : "+sid);
		System.out.println("������ �̸� : "+sname);
		System.out.println("������ ��� : "+scnt);
		System.out.println("������ ���� : "+sprice);
		System.out.println("������ �Ǹ��� : "+pname);
		System.out.println("�԰� ��¥ : "+date);
	}
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScnt() {
		return scnt;
	}
	public void setScnt(int scnt) {
		this.scnt = scnt;
	}
	public int getSprice() {
		return sprice;
	}
	public void setSprice(int sprice) {
		this.sprice = sprice;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
