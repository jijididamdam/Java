package Day0922_Test;

public class Goods {
	String gname = null;
	int cnt = 0;
	int price = 0;
	
	public void setting(String gname, int cnt, int price) {
		this.gname=gname;
		this.cnt=cnt;
		this.price=price;
	}

	public void prt() {
		System.out.println("물건이름 : "+this.gname);
		System.out.println("수량 : "+this.cnt);
		System.out.println("단가 : "+this.price);
	}
}


