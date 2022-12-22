package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	Scanner in= new Scanner(System.in);
	ArrayList<Goods> basket = new ArrayList<>();
	Array_GoodsManager gm2 = null;
	String name = "Guest";
	//고객별로 쇼핑이 가능하도록 확장
	/*String id = null;
	 * int point=0;
	 * String addr=null;
	 */
	public Member(Array_GoodsManager gm2) {
		this.gm2=gm2;
	}
	
	public void goShopping() {
		for(;;) {
			System.out.println("1. 구매하기");
			System.out.println("2. 장바구니");
			System.out.println("3. 이전메뉴");
			int selMenu = in. nextInt();
			in.nextLine();
			if(selMenu==1) {
				shopping();
			} else if (selMenu==2) {
				viewBasket();
			} else if (selMenu==3) {
				break;
			}
		}
	}
	//코드 5줄로 쇼핑하기 > 구매하기 누르면 물건의 목록이 뜨게 하라
	
	
	private void viewBasket() {
		// TODO Auto-generated method stub
		// 번호 선택해서 장바구니에 해당 물건 주소 저장
				/*System.out.println("번호를 선택하시오");
				int no = in.nextInt();
				in.nextLine();					
				basket.add(gm2.aList.get(no));
				for(int i=0; i< basket.size();i++) {
					basket.get(i).prt();
				}*/
		//이름으로 검색해서 장바구니에 해당 이름에 수량 추가
		int ccnt=1;
		System.out.println("물건의 이름을 입력하세요");
		String scname = in.nextLine();
		for(int i=0; i<gm2.aList.size(); i++) {

			if(gm2.aList.get(i).name.contains(scname)) {
				Goods input = new Goods();
				input.setting(scname, gm2.aList.get(i).id, ccnt, gm2.aList.get(i).price);
				basket.add(input);
				
			}
			
		}
		
		for(int i=0; i< basket.size();i++) {
			basket.get(i).prt();
		}
		
		
		
	}

	public void shopping() {
		//System.out.println("쇼핑 공사중");
		/*
		 * 1. 물건의 리스트보기
		 * 2. 물건 선택하기
		 * 3. 자신의 장바구니에 담기
		 */		
		gm2.listGoods();
		
		
		
	}

}
