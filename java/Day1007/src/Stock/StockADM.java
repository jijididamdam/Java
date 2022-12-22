package Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class StockADM {

	Scanner in = new Scanner(System.in);
	StockDAO sdao = new StockDAO();
	ArrayList<Stock> slist = sdao.all();

	public void runStock() {
		for (;;) {
			System.out.println("1. 물건등록");
			System.out.println("2. 물건수정");
			System.out.println("3. 물건삭제");
			System.out.println("4. 물건검색");
			System.out.println("5. 재고량분석 ");
			System.out.println("6. 돌아가기");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				sput();
			} else if (sel == 2) {
				smod();
			} else if (sel == 3) {
				sdel();
			} else if (sel == 4) {
				ssch();
			} else if (sel == 5) {
				sans();
			} else if (sel==6) {
				break;
			}
		}
	}

	private void sans() {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < slist.size(); i++) {
			sum += slist.get(i).getScnt();
		}
		int avg = sum / slist.size();
		System.out.println(avg);
		for (int i = 0; i < slist.size(); i++) {
			if (slist.get(i).getScnt() > avg) {
				slist.get(i).sprt();
			}
		}
	}

	private void ssch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 물건의 아이디를 입력하세요");
		String sid = in.nextLine();
		for (int i = 0; i < slist.size(); i++) {
			if (sid.equals(slist.get(i).getSid())) {
				slist.get(i).sprt();
				return;
			}
		}
		System.out.println("물건이 없습니다.");
	}

	private void sdel() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 물건의 아이디를 입력하세요");
		String did = in.nextLine();
		sdao.dels(did);
	}

	public int same(String mid) {

		for (int i = 0; i < slist.size(); i++) {
			if (mid.equals(slist.get(i).getSid())) {
				return 1;
			}
		}
		return 2;
	}

	private void smod() {
		System.out.println("수정할 물건의 아이디를 입력하세요");
		String mid = in.nextLine();
		if (same(mid) == 1) {
			System.out.println("수정할 항목을 고르세요.");
			System.out.println("1. 물건이름");
			System.out.println("2. 재고");
			System.out.println("3. 가격");
			System.out.println("4. 판매자이름");
			System.out.println("5. 입고날짜");

			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				String cal = "sname";
				System.out.println("새로운 물건의 이름을 입력하세요.");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 2) {
				String cal = "scnt";
				System.out.println("재고 몇으로 수정할까요?");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 3) {
				String cal = "sprice";
				System.out.println("가격 몇으로 수정할까요?");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 4) {
				String cal = "pname";
				System.out.println("새로운 판매자를 입력하세요");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 5) {
				String cal = "dt";
				System.out.println("새로운 날짜를 입력하세요");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			}
		}

	}

	private void sput() {
		Stock st = new Stock();
		System.out.println("새로운 물건의 아이디를 입력하세요");
		String nid = in.nextLine();
		st.setSid(nid);
		System.out.println("새로운 물건의 이름을 입력하세요");
		String nname = in.nextLine();
		st.setSname(nname);
		System.out.println("새로운 물건의 재고를 입력하세요");
		int ncnt = in.nextInt();
		in.nextLine();
		st.setScnt(ncnt);
		System.out.println("새로운 물건의 가격을 입력하세요");
		int nprice = in.nextInt();
		in.nextLine();
		st.setSprice(nprice);
		System.out.println("새로운 물건의 판매자를 입력하세요");
		String npname = in.nextLine();
		st.setPname(npname);
		sdao.putS(st);
		System.out.println("입력완료");
	}

}
