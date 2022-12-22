package order;

import java.util.ArrayList;
import java.util.Scanner;

import menu.*;

public class OrderMGE {
	private Scanner in = new Scanner(System.in);
	private ArrayList<Menu_INF> menuList = new ArrayList<>();
	
	public OrderMGE() {
		while(true) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				order();
			}else if(selMenu==2) {
				orderList();
			}else if(selMenu==3) {
				break;
			}
		}
	}
	private void orderList() {
		for(Menu_INF m : menuList) {
			m.payCount();
		}
	}
	private void order() {
		System.out.println("1. ��� / 2.������ / 3. ���");
		System.out.println("�����ϼ���");
		int selMenu = in.nextInt();
		in.nextLine();
		Menu_INF nowMenu = null;
		if(selMenu==1) {
			nowMenu = new Ramyun();
		}else if(selMenu==2) {
			nowMenu = new DDukBok();
		}else if(selMenu==3) {
			nowMenu = new DolDolRice();
		}
		
		System.out.println(" ������ �޴� ���� ------------");
		nowMenu.info();
		System.out.println(" �ֹ��ϱ� -----------------");
		nowMenu.inputBasket();
		System.out.println(" ����ϱ� -----------------");
		nowMenu.payCount();
		System.out.println("-- �ֹ��� �ּż� �����մϴ� ------");
		
		menuList.add(nowMenu);
	}

	private void menu() {
		System.out.println("1. �ֹ��ϱ�");
		System.out.println("2. �ֹ���������");
		System.out.println("3. ����");
		System.out.println("�����ϱ� >>");
	}

}
