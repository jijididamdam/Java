package menu;

import java.util.Scanner;

public class DolDolRice extends OrderInfo implements Menu_INF{
	String[] dolRiceList = {"��ġ", "�Ϲ�","���"};
	int[] price = {3000,2000,3000};
	private Scanner in = new Scanner(System.in);
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("�������� ������ ��������");
	}

	@Override
	public void inputBasket() {
		// TODO Auto-generated method stub
		System.out.println("1. "+dolRiceList[0] + "2. "+dolRiceList[1]+ "3. "+dolRiceList[2]);
		int inputMenu = in.nextInt();
		in.nextLine();
		super.menuName= dolRiceList[inputMenu-1];
		super.price=price[inputMenu-1];
		System.out.println("�� ���� �Է��ϼ���");
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
