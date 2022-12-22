package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Array_GoodsManager {
	//Goods[] gList = new Goods[10];
	ArrayList<Goods> aList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	Array_GoodsManager() {

	}
	
	public void runGoods() {
		for (;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				addGoods();
			} else if (selMenu == 3) {
				listGoods();
			} else if (selMenu == 2) {
				modGoods();
			} else if (selMenu == 4) {
				delGoods();
			} else if (selMenu == 5) {
				searchGoods();
			
			} else if (selMenu == 6) {
				break;
			}
		}
	}

	private void searchGoods() {
		// TODO Auto-generated method stub
		System.out.println("검색할 이름을 입력하세요");
		String sename=in.nextLine();
		for(int i=0; i<aList.size(); i++) {
			String word = aList.get(i).name;
			if(word.contains(sename)) {
				aList.get(i).prt();
				break;
			}
		}
	}

	private void delGoods() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 이름을 입력하세요");
		String delName = in.nextLine();
		for(int i=0; i < aList.size(); i++) {
			String word = aList.get(i).name;
			if (delName.equals(word)) {
				//aList.get(i).setting(null, null, 0, 0);
				aList.remove(i);
			}
			System.out.println(i);
			aList.get(i).prt();	
		}
	}

	private void modGoods() {
		// TODO Auto-generated method stub
		System.out.println("수정할 이름을 입력하세요");
		String modName = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < aList.size(); i++) {
			String word = aList.get(i).name;
			if (modName.equals(word)) {
				System.out.println("수량을 입력하세요");
				int newInt = in.nextInt();
				in.nextLine();
				aList.get(i).cnt = newInt;

				System.out.println("가격을 입력하세요");
				newInt = in.nextInt();
				in.nextLine();
				aList.get(i).price = newInt;
				flag=false;
				break;
			}
		}
		if (flag) {
			System.out.println("이름이 없습니다.");
		}
	}

	public void listGoods() {
		// TODO Auto-generated method stub
		for (int i = 0; i < aList.size(); i++) {
			System.out.println( i + " 번 정보----");
			aList.get(i).prt();
		}
	}

	private void addGoods() {
		// TODO Auto-generated method stub
		Goods input = new Goods();
		System.out.println("이름 입력");
		String name = in.nextLine();
		System.out.println("아이디입력");
		String id = in.nextLine();
		System.out.println("수량입력");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("가격입력");
		int price = in.nextInt();
		in.nextLine();
		input.setting(name, id, cnt, price);
		aList.add(input);
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 물건등록");
		System.out.println("2. 물건수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 물건삭제");
		System.out.println("5. 검색하기");
		System.out.println("6. 이전메뉴");
	}

}
