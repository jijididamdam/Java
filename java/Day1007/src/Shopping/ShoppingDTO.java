package Shopping;

public class ShoppingDTO {
	String cid = null;
	String sid = null;
	int cnt = 0;
	int cprice = 0;
	String cdt = null;
	
	public void shprt() {
		System.out.println("�����̵� : "+cid);
		System.out.println("���Ǿ��̵� : "+sid);
		System.out.println("���� ���� : "+cnt);
		System.out.println("�� ���� : "+cprice);
		System.out.println("���ų�¥ : "+cdt);
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
