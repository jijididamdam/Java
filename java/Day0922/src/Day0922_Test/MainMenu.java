package Day0922_Test;

import java.util.Scanner;

/* �������� ��, ù��° ȭ��
 * 1 - �α��� Ŭ������ �̵��Ͽ� ���� ���� 
 * 2- �ٷ� �����ϱ�� �̵�  ~ ��, ��ȸ���� ��ٱ��� ��� �Ұ� = ��ǰ����� �����ϱ⸸ ����
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
		System.out.println("1. �α���");
		System.out.println("2. ��ȸ�� �����ϱ�");
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
