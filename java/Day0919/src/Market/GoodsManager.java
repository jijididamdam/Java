package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {
	Goods[] gList = new Goods[10]; // 참조자료형의 초기값은 null이다
	ArrayList<Goods> aList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	// Goods newGoods = new Goods(); ~ 여기 선언문에 넣으면 하나의 객체만 만들어져 내용을 입력해도 한 개의 객체가 계속
	// 수정되는 형식 (추가X)
	GoodsManager() {
		// 물건을 관리하는 객체 : 물건 등록, 수정, 삭제, 물건 1개
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
			}
		}
	}

	private void searchGoods() {
		// 이름으로 검색한다. 단 이름은 유니크하다.
		// 수준 1. 이름이 완전히 일치하면 -> 문자열 객체에서 어떤 메서드 활용할까?  		  equals
		// 수준 2. 검색이름이 실제이름에 포함되면 -> 문자열 객체에서 어떤 메서드를 활용할까?    indexOf,  contains
		System.out.println("검색할 이름을 입력하세요");
		String modName=in.nextLine();
		for(int i=0;i<gList.length;i++) {
			if(gList[i]!=null) {
				//수준1. 이름이 유니크하고 일치하니...더이상 순회할 이유가 없다.
				if(gList[i].name.equals(modName)) {
					gList[i].prt();
					break;
				}
				// 수준2. 이름이 포함되니 더 순회해야 한다,
				if(gList[i].name.contains(modName)) {
					gList[i].prt();
					//break; 40번 이유로 삭제
				}
			}
		}
	}

	private void delGoods() {
		// 이름으로 검색하여 삭제한다.
		System.out.println("수정할 이름을 입력하세요");
		String modName = in.nextLine();
		for(int i=0; i <gList.length; i++) {
			if(gList[i]!=null) {
				if(gList[i].name.equals(modName)) {
					gList[i]=null;
					System.out.println(modName+"삭제완료");
					break;
				}
			}
		}
		
	}

	private void modGoods() {
		// 이름으로 수정하시오 ... 이름으로 수정하는데 수량하고 가격만 수정이 가능하다
		System.out.println("수정할 이름을 입력하세요");
		String modName = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.length; i++) {
			if (gList[i] != null) {
				if (gList[i].name.equals(modName)) {
					System.out.println("수량을 입력하세요");
					int newInt = in.nextInt();
					in.nextLine();
					gList[i].cnt = newInt;

					System.out.println("가격을 입력하세요");
					newInt = in.nextInt();
					in.nextLine();
					gList[i].price = newInt;
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("이름이 없습니다.");
		}
	}

	private void addGoods() { // 물건추가
		// TODO Auto-generated method stub
		Goods newGoods = new Goods(); // 물건을 추가할 때마다 객체를 만든다 ~ 여기에 작성해야 여러 객체 만들어짐 // 배열 순서달라도 주소값 같으면 객체 공용함
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
		newGoods.setting(name, id, cnt, price);

		for (int i = 0; i < gList.length; i++) {
			if (gList[i] == null) {
				gList[i] = newGoods; // 객체의 주소값 저장 ~ 객체 저장이 아님
				break;
			}
		}
	}

	private void listGoods() {
		// TODO Auto-generated method stub
		for (int i = 0; i < gList.length; i++) {
			if (gList[i] != null) {
				System.out.println(i + " 번 정보 ------");
				gList[i].prt();
				System.out.println("----------------");
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 물건등록");
		System.out.println("2. 물건수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 물건삭제");
	}

}
