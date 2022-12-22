package DAO;

import java.util.Scanner;

import DTO.ddockbokkiDTO;
import Main.Order;

public class ddockbokki implements allDAO {

	Scanner in = new Scanner(System.in);
	
	ddockbokkiDTO dt = null;
	
	Order od = new Order();
	
	



	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("맛에 빠져서 하나 더 먹으려니 없어졌네");
	}

	@Override
	public void bask() {
		
		ddockbokkiDTO dk = new ddockbokkiDTO();
		System.out.println("떡 종류 선택 : 쌀떡, 밀떡");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("맵기 조절 선택 : 강 , 중간 , 보통");
			String mcel = in.nextLine();
			if (sm(mcel) == 3) {
				System.out.println("몇인분? 1인분에 2000원입니다.");
				int ccel = in.nextInt();
				in.nextLine();
				dk.setSddoc(bsel);
				dk.setLevel(mcel);
				dk.setCcnt(ccel);
				od.list.add(dk);
			}
		}
	}

	public int same(String bsel) {
		if (bsel.equals("쌀떡")) {
			return 1;
		} else if (bsel.equals("밀떡")) {
			return 1;
		} else {
			System.out.println("잘못 입력하였습니다.");
			return 2;
		}
	}

	public int sm(String msel) {
		if (msel.equals("강")) {
			return 3;
		} else if (msel.equals("중간")) {
			return 3;
		} else if (msel.equals("보통")) {
			return 3;
		} else {
			System.out.println("잘못 입력하였습니다.");
			return 4;
		}
	}

	@Override
	public void calc() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 0; i < od.list.size(); i++) {
			sum+=od.list.;
		}
		System.out.println("총 떡볶이 가격 : "+(sum*2000)+"원");
	}

}
