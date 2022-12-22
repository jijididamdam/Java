package Med;

public class Med_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("프로그램의 시작");
		Med_2 m= new Med_2();
		System.out.println(m.point);
		System.out.println(m.pwd);
		m.a(); // 리턴없는 메서드
		m.aa("kkk"); // 메서드호출부  kkk로 출력됨 ~ 리턴값이 있는데 호출부에서 그 리턴값을 무시함
		int aaa = m.aa("abfa"); // 리턴값을 받아서 aaa 대입 ~ 출력은 abfa가 나옴 
		/*System.out.println(aaa); ~ 위 코드로 인하여 return 값인 1이 나옴 ~ 
								     id는 String이지만 aa()메서드는 int 타입이여서 return값을 1로 지정해주었기 때문에 1이 나옴 */
		m.aa("-----");
		m.aaa();
		System.out.println("프로그램의 종료");
	}

}
