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
		System.out.println("�����̸� : "+this.gname);
		System.out.println("���� : "+this.cnt);
		System.out.println("�ܰ� : "+this.price);
	}
}


