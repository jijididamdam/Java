package Train;

public class StockADM {
	String id;
	int cnt = 10;
	int price;
	
	public void pc(int p) {
		System.out.println("���� : "+p);
		price=p;
	}
	
	public int cc() {
		System.out.println("���� : "+ cnt);
		return cnt;
	}
	
	public void prt() {
		System.out.println("���̵� : "+id+" ���� : " +cnt+" �ܰ� : " +price);
	}
	
	public void save(String idd, int cntt,int pricee) {
		price=pricee;
		cnt=cntt;
		id=idd;
	}

}
