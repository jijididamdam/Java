package Day0922_Test;

public class BasketGoods {
	
	MemberManager ct = null;
	GoodsManager buyGoods = null; // 
	String id=null;               // ���� �� ���̵� ������ ����
	String gname=null;			  // ��ϵ� ������ �̸� ������ ����
	int buycnt=0;				  // ���� ���ϴ�(�Է���) ���Ÿ� ���ϴ� ���� ����
	int buyprice=0;				  // �ش� ������ ������ŭ�� �� ����	( ���� 1���� ���� * ������ ��Ÿ�� )
	
	
	public BasketGoods(MemberManager ct,GoodsManager buyGoods) {
		this.ct=ct;
		this.buyGoods=buyGoods;
	}
	
	public void setting(String id,String gname,int buycnt, int buyprice) {
		this.id=id;
		this.gname=gname;
		this.buycnt=buycnt;
		this.buyprice=buyprice;
	}
	
	public void prt() {
		System.out.println("�� ���̵� : "+id);
		System.out.println("���� ��ǰ : "+gname);
		System.out.println("������ ���� : "+buycnt);
		System.out.println("�� ���� : "+buyprice);
	}


}
