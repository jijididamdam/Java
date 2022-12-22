package Market;
//물건 한개를 의미하는 객체
public class Goods {
	String name=null; //이름
	String id=null;  // 아이디
	int cnt=0;       // 수량
	int price=0;     // 가격
	
	//물건의 이름을 저장하는 메서드
	public void setting(String name,String id, int cnt, int price) {
		//this는 자기 자신의 전역변수를 구분할 때 사용하는 키워드
		this.name=name;
		this.id=id;
		this.cnt=cnt;
		this.price=price;
	}
	
	public void prt() {
		System.out.println("이름 : "+this.name);
		System.out.println("아이디 : "+this.id);
		System.out.println("수량 : "+this.cnt);
		System.out.println("단가 : "+this.price);
	}
}
