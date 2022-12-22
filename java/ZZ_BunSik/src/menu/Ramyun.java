package menu;

import java.util.HashMap;
import java.util.Scanner;

public class Ramyun extends OrderInfo implements Menu_INF{
	
	private HashMap<String,Integer> ramyunList = new HashMap<>();
	private Scanner in = new Scanner(System.in);

	public Ramyun(){
		ramyunList.put("�����", 1500);
		ramyunList.put("����", 2000);
		ramyunList.put("�Ƚɶ��", 1800);
	}
	
	
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("���� ���� �����ϻ�, ������ ����� �ϼ�");
	}

	@Override
	public void inputBasket() {
		for(String menu : ramyunList.keySet()) {
			System.out.println(menu+" : "+ramyunList.get(menu));
		}
		System.out.println("�޴��̸��� �Է��ϼ���");
		String inputMenu = in.nextLine();
		super.menuName=inputMenu; //
		super.price=ramyunList.get(inputMenu);//
		System.out.println("������ �Է��ϼ���");
		int inputcnt = in.nextInt();
		in.nextLine();
		super.cnt=inputcnt;//
				
	}
	@Override
	public void payCount() {
		super.prt();		
	}

}
