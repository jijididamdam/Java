package Shopping;

public class ShoppingDTO {
	String cid = null;
	String sid = null;
	int cnt = 0;
	int cprice = 0;
	String cdt = null;
	
	public void shprt() {
		System.out.println("고객아이디 : "+cid);
		System.out.println("물건아이디 : "+sid);
		System.out.println("물건 개수 : "+cnt);
		System.out.println("총 가격 : "+cprice);
		System.out.println("구매날짜 : "+cdt);
	}
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCdt() {
		return cdt;
	}
	public void setCdt(String cdt) {
		this.cdt = cdt;
	}
	
	

}
