package menu;

import java.util.Scanner;

public class DDukBok extends OrderInfo implements Menu_INF{
	
	String[] dDukList = {"�Ҷ�", "�ж�"};
	String[] level = {"��","�߰�","����"};
	private Scanner in = new Scanner(System.in);
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("���� ������ �ϳ� �� �������� ��������~~");
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
		System.out.println("�κ��� �Է��ϼ���");
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
