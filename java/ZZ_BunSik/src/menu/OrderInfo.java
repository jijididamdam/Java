package menu;

public class OrderInfo {
	String menuName=null;
	String orderInfo="����";
	int cnt=0;
	int price=0;

	public void prt() {
		System.out.println("�޴��̸� : "+menuName);
		System.out.println("�䱸���� : "+orderInfo);
		System.out.println("��     �� : "+price);
		System.out.println("��     �� : "+cnt);
		System.out.println("--------- �ݾ� : "+(cnt*price));
	}

}
