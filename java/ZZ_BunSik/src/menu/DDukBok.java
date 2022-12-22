package menu;

import java.util.Scanner;

public class DDukBok extends OrderInfo implements Menu_INF{
	
	String[] dDukList = {"쌀떡", "밀떡"};
	String[] level = {"강","중간","보통"};
	private Scanner in = new Scanner(System.in);
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("맛에 빠져서 하나 더 먹으려니 없어졌네~~");
	}

	@Override
	public void inputBasket() {
		System.out.println("1. "+dDukList[0] + "2. "+dDukList[1]);
		int inputMenu = in.nextInt();
		in.nextLine();
		super.menuName= dDukList[inputMenu-1];
		System.out.println("1. "+level[0] + "2. "+level[1]+ "3. "+level[2]);
		int inputlevel = in.nextInt();
		in.nextLine();
		super.orderInfo = level[inputlevel-1];
		super.price=2000;
		System.out.println("인분을 입력하세요");
		int inputCnt = in.nextInt();
		in.nextLine();
		super.cnt=inputCnt;
		
	}

	@Override
	public void payCount() {
		// TODO Auto-generated method stub
		super.prt();
	}

}
