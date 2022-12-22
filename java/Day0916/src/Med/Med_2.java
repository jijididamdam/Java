package Med;

public class Med_2 {

	int point=80;
	String id;
	String name;
	String pwd="1234";
	
	Med_2(){
		System.out.println("Med_2 생성자");
	}
	
	public void a() {
		System.out.println(point);
	}
	//정의부
	// 
	public int aa(String id) {
		System.out.println(id);
		return 1;   // 
	}
	
	public String aaa() {
		return name;
	}
	
	
}
