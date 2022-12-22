package menu;

public class OrderInfo {
	String menuName=null;
	String orderInfo="없음";
	int cnt=0;
	int price=0;

	public void prt() {
		System.out.println("메뉴이름 : "+menuName);
		System.out.println("요구사항 : "+orderInfo);
		System.out.println("단     가 : "+price);
		System.out.println("수     량 : "+cnt);
		System.out.println("--------- 금액 : "+(cnt*price));
	}

}
