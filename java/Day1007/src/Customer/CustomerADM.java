package Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerADM {
	CustomerDAO cdao = new CustomerDAO();
	Scanner in = new Scanner(System.in);
	private ArrayList<Customer> plist = null;

	public void runc() {
		for (;;) {
			plist = cdao.allCus();
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				put();
			} else if (sel == 2) {
				prt();
			} else if (sel == 3) {
				mod();
			} else if (sel == 4) {
				del();
				plist = null;
			} else if (sel == 5) {
				sch2();

			} else if (sel == 6 ) {
				break;
			}
			plist = null;
		}
	}

	private void sch2() {
		// TODO Auto-generated method stub

		System.out.println("검색할 회원의 아이디나 이름을 입력하세요");
		String ss = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getCid().contains(ss)) {
				plist.get(i).cprt();
				;
			} else if (plist.get(i).getCname().contains(ss)) {
				plist.get(i).cprt();
			}
		}
	}

	private void sch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 회원의 아이디를 입력하세요");
		String sid = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (sid.equals(plist.get(i).getCid())) {
				plist.get(i).cprt();
				return;
			}
		}
		System.out.println("회원이 없습니다.");
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 회원의 아이디를 입력해주세요");
		String did = in.nextLine();
		cdao.delc(did);
	}

	public int same(String mid) {

		for (int i = 0; i < plist.size(); i++) {
			if (mid.equals(plist.get(i).getCid())) {
				return 1;
			}
		}
		return 2;
	}

	private void mod() {
		System.out.println("수정할 아이디를 입력하세요");
		String mid = in.nextLine();
		if (same(mid) == 1) {
			choice();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				String cal = "name";
				System.out.println("새로운 이름을 입력하세요");
				String mname = in.nextLine();
				cdao.modc(mid, mname, cal);
			} else if (sel == 2) {
				String cal = "pass";
				System.out.println("새로운 비밀번호를 입력하세요");
				String mpw = in.nextLine();
				cdao.modc(mid, mpw, cal);
			}
		} else {
			System.out.println("일치하는 회원이 없습니다.");
			return;
		}

	}

	private void choice() {
		System.out.println("수정할 정보의 번호를 입력하세요");
		System.out.println("1. 이름 수정");
		System.out.println("2. 비밀번호 수정");

	}

	private void prt() {
		for (Customer ct : plist) {
			ct.cprt();
		}

	}

	public int replay(String nid) {

		for (int i = 0; i < plist.size(); i++) {
			if (nid.equals(plist.get(i).getCid())) {
				System.out.println("기존 아이디가 있습니다.");
				put();
				return 1;
			}
		}
		return 2;
	}

	private void put() {
		System.out.println("신규 회원의 아이디를 입력하세요");
		String nid = in.nextLine();
		if (plist != null) {
			if (replay(nid) == 1) {
				replay(nid);
			} else {
				set(nid);
			}
		} else {
			set(nid);
		}

	}

	private void set(String nid) {
		Customer ct = new Customer();
		ct.setCid(nid);
		System.out.println("신규 회원의 이름을 입력하세요");
		String nname = in.nextLine();
		ct.setCname(nname);
		System.out.println("신규 회원의 비밀번호를 입력하세요");
		String npw = in.nextLine();
		ct.setCpw(npw);
		/*
		 * System.out.println("신규 회원의 주소를 입력하세요"); String naddr = in.nextLine();
		 * ct.setAddr(naddr);
		 */
		// 포인트는 자동 0 으로 시작
		cdao.putc(ct);

	}

	private void menu() {

		System.out.println("회원 관리 시스템");
		System.out.println("1. 신규 고객 등록");
		System.out.println("2. 고객 목록 보기");
		System.out.println("3. 고객 정보 수정");
		System.out.println("4. 고객 정보 삭제");
		System.out.println("5. 고객 정보 검색");
		System.out.println("6. 돌아가기");
	}

}
