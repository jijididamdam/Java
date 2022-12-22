package Main;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.allDAO;
import DAO.ddockbokki;
import DAO.kimbab;
import DAO.ramen;

public class Order {

	Scanner in = new Scanner(System.in);
	allDAO adao = null;

	public ArrayList<Object> list = new ArrayList<>();

	public Order() {
		
		System.out.println("1. 주문하기");
		System.out.println("2. 주문 내역 보기");

		int sel = in.nextInt();
		in.nextLine();

		if (sel == 1) {
			run();
		} else if (sel == 2) {
			adao.calc();
		}
	}

	void run() {
		
		for (;;) {
			
			System.out.println("음식점 메뉴 선택");
			System.out.println("1. 라면");
			System.out.println("2. 떡볶이");
			System.out.println("3. 김밥");
			System.out.println("4. 이전메뉴");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				adao = new ramen();
			} else if (sel == 2) {
				adao = new ddockbokki();
			} else if (sel == 3) {
				adao = new kimbab();
			} else if (sel == 4) {
				return;
			}

			running();
		}
	}

	private void running() {
		for (;;) {
			
			// TODO Auto-generated method stub
			System.out.println("1. 설명보기");
			System.out.println("2. 장바구니담기");
			System.out.println("3. 계산하기");
			System.out.println("4. 돌아가기");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				adao.exp();

			} else if (sel == 2) {
				adao.bask();

			} else if (sel == 3) {
				adao.calc();

			} else if (sel == 4) {				
				return;
			}
		}

	}

	

}
