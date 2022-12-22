package Day0922_Test;

import java.util.Scanner;

/* 실행했을 때, 첫번째 화면
 * 1 - 로그인 클래스로 이동하여 마저 실행 
 * 2- 바로 쇼핑하기로 이동  ~ 단, 비회원은 장바구니 사용 불가 = 상품보기와 구매하기만 가능
 */


public class MainMenu {

	Scanner in = new Scanner (System.in);
	
	GoodsManager gm = new GoodsManager();
	MemberManager client = new MemberManager();
	Shopping sh = new Shopping(gm,client);
	Login lg = new Login(client,gm,sh);

	MainMenu() {
		for(;;) {
			menu_1();
			int sel = in.nextInt();
			in.nextLine();
			if(sel==1) {
				lg.runLogin();				
			} if(sel==2) {
				sh.x_runShop();
			}
		}
	}

	public void  menu_1() {
		// TODO Auto-generated method stub
		System.out.println("1. 로그인");
		System.out.println("2. 비회원 쇼핑하기");
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
