package menu;

import java.util.HashMap;
import java.util.Scanner;

public class Ramyun extends OrderInfo implements Menu_INF{
	
	private HashMap<String,Integer> ramyunList = new HashMap<>();
	private Scanner in = new Scanner(System.in);

	public Ramyun(){
		ramyunList.put("쉰라면", 1500);
		ramyunList.put("쥔라면", 2000);
		ramyunList.put("안심라면", 1800);
	}
	
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("면은 그저 시작일뿐, 국물이 라면의 완성");
	}

	@Override
	public void inputBasket() {
		for(String menu : ramyunList.keySet()) {
			System.out.println(menu+" : "+ramyunList.get(menu));
		}
		System.out.println("메뉴이름을 입력하세요");
		String inputMenu = in.nextLine();
		super.menuName=inputMenu; //
		super.price=ramyunList.get(inputMenu);//
		System.out.println("수량을 입력하세요");
		int inputcnt = in.nextInt();
		in.nextLine();
		super.cnt=inputcnt;//
				
	}
	@Override
	public void payCount() {
		super.prt();		
	}

}
