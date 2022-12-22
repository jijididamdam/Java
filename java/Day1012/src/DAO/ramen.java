package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.ramenDTO;

public class ramen implements allDAO {

	Scanner in = new Scanner(System.in);

	ArrayList<ramenDTO> rlist = new ArrayList<>();

	//private String sramen = null;
	//private int ccnt = 0;

	

	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("면은 그저 시작일뿐, 국물이 라면의 완성");
	}

	@Override
	public void bask() {
		// TODO Auto-generated method stub
		ramenDTO rm = new ramenDTO();
		System.out.println("무슨 라면인지 입력해주세요");
		System.out.println("* 쉰라면 1500원");
		System.out.println("* 쥔라면 2000원");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("몇개를 담을까요?");
			int ccel = in.nextInt();
			in.nextLine();
			rm.setSramen(bsel);
			rm.setCcnt(ccel);
			rlist.add(rm);
		}
	}

	public int same(String bsel) {
		if (bsel.equals("쉰라면")) {
			return 1;
		} else if (bsel.equals("쥔라면")) {
			return 1;
		} else {
			System.out.println("잘못 입력하였습니다.");
			return 2;
		}
	}

	@Override
	public void calc() {
		int sum1 = 0;
		int sum2 = 0;

		// TODO Auto-generated method stub
		for (int i = 0; i < rlist.size(); i++) {
			if ("쉰라면".equals(rlist.get(i).getSramen())) {
				sum1 += rlist.get(i).getCcnt();
			} else {
				sum2 += rlist.get(i).getCcnt();
			}
		}
		System.out.println("총 쉰라면 가격 : " + (sum1 * 1500) + "원");
		System.out.println("총 쥔라면 가격 : " + (sum2 * 2000) + "원");
	}

}
