package Train;

public class StockADM {
	String id;
	int cnt = 10;
	int price;
	
	public void pc(int p) {
		System.out.println("가격 : "+p);
		price=p;
	}
	
	public int cc() {
		System.out.println("수량 : "+ cnt);
		return cnt;
	}
	
	public void prt() {
		System.out.println("아이디 : "+id+" 수량 : " +cnt+" 단가 : " +price);
	}
	
	public void save(String idd, int cntt,int pricee) {
		price=pricee;
		cnt=cntt;
		id=idd;
	}

}
