package Day0922_Test;

public class BasketGoods {
	
	MemberManager ct = null;
	GoodsManager buyGoods = null; // 
	String id=null;               // 기존 고객 아이디 가져와 저장
	String gname=null;			  // 등록된 물건의 이름 가져와 저장
	int buycnt=0;				  // 고객이 원하는(입력한) 구매를 원하는 수량 저장
	int buyprice=0;				  // 해당 물건의 수량만큼의 총 가격	( 물건 1개당 가격 * 수량을 나타냄 )
	
	
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
		System.out.println("고객 아이디 : "+id);
		System.out.println("구매 상품 : "+gname);
		System.out.println("구매할 수량 : "+buycnt);
		System.out.println("총 가격 : "+buyprice);
	}


}
