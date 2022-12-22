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
		System.out.println("1. 라면 / 2.떡볶이 / 3. 깁밥");
		System.out.println("선택하세요");
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
		
		System.out.println(" 선택한 메뉴 정보 ------------");
		nowMenu.info();
		System.out.println(" 주문하기 -----------------");
		nowMenu.inputBasket();
		System.out.println(" 계산하기 -----------------");
		nowMenu.payCount();
		System.out.println("-- 주문해 주셔서 감사합니다 ------");
		
		menuList.add(nowMenu);
	}

	private void menu() {
		System.out.println("1. 주문하기");
		System.out.println("2. 주문내역보기");
		System.out.println("3. 종료");
		System.out.println("선택하기 >>");
	}

}
