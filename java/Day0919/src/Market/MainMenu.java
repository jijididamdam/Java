package Market;

import java.util.Scanner;

public class MainMenu {
	Array_GoodsManager gm = new Array_GoodsManager();
	Member shop = new Member(gm);
	Scanner inin= new Scanner(System.in);
	
	MainMenu() {
		for(;;) {
			menu();
			int selMenu=inin.nextInt();
			inin.nextLine();
			if(selMenu==1) {				
				gm.runGoods();       // ������ �ʱ�� GoodsManager()
			} else if (selMenu==2) {
				 shop.goShopping();
			}
		}
	}
	
	public void menu() {
		System.out.println("1. ���ǰ���");
		System.out.println("2. �����ϱ�");
	}
	

}
