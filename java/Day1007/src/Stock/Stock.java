package Stock;

public class Stock {
	String sid=null;
	String sname=null;
	int scnt = 0;
	int sprice = 0;
	String pname=null;
	String date=null;
	
	public void sprt() {
		System.out.println("물건의 아이디 : "+sid);
		System.out.println("물건의 이름 : "+sname);
		System.out.println("물건의 재고 : "+scnt);
		System.out.println("물건의 가격 : "+sprice);
		System.out.println("물건의 판매자 : "+pname);
		System.out.println("입고 날짜 : "+date);
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
