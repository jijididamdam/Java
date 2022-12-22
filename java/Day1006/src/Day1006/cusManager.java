package Day1006;

import java.util.ArrayList;
import java.util.Scanner;

public class cusManager {

	cusDAO cdao = new cusDAO();
	Scanner in = new Scanner(System.in);
	private ArrayList<cusDTO> plist = null;
	

	public void run() {
		for (;;) {
			plist=cdao.allPrt();
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
				plist=null;
			} else if (sel == 5) {
				sch2();

			}
			plist=null;
		}
	}

	private void sch2() {
		// TODO Auto-generated method stub
		
		System.out.println("검색할 회원의 아이디나 이름을 입력하세요");
		String ss = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getId().contains(ss)) {
				plist.get(i).prt();
			} else if (plist.get(i).getName().contains(ss)) {
				plist.get(i).prt();
			} 
		}
	}

	private void sch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 회원의 아이디를 입력하세요");
		String sid = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (sid.equals(plist.get(i).getId())) {
				plist.get(i).prt();
				return;
			}
		}
		System.out.println("회원이 없습니다.");
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 회원의 아이디를 입력해주세요");
		String did = in.nextLine();
		cdao.delcus(did);
	}
	
	public int same(String mid) {

		for (int i = 0; i < plist.size(); i++) {
			if (mid.equals(plist.get(i).getId())) {
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
				cdao.modcus(mid, mname, cal);
			} else if (sel == 2) {
				String cal = "pass";
				System.out.println("새로운 비밀번호를 입력하세요");
				String mpw = in.nextLine();
				cdao.modcus(mid, mpw, cal);
			} else if (sel == 3) {
				String cal = "addr";
				System.out.println("새로운 주소를 입력하세요");
				String maddr = in.nextLine();
				cdao.modcus(mid, maddr, cal);
			} else if (sel == 4) {
				String cal = "point";
				System.out.println("새로운 포인트를 입력하세요");
				String mpoint = in.nextLine();
				cdao.modcus(mid, mpoint, cal);
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
		System.out.println("3. 주소 수정");
		System.out.println("4. 포인트 수정");

	}

	private void prt() {
		for (cusDTO ct : plist) {
			ct.prt();
		}

	}


	public int replay(String nid) {

		for (int i = 0; i < plist.size(); i++) {
			if (nid.equals(plist.get(i).getId())) {
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
		if (replay(nid) == 1) {
			replay(nid);
		} else {
			set(nid);
		}

	}
	
	private void set(String nid) {
		cusDTO ct = new cusDTO();
		ct.setId(nid);
		System.out.println("신규 회원의 이름을 입력하세요");
		String nname = in.nextLine();
		ct.setName(nname);
		System.out.println("신규 회원의 비밀번호를 입력하세요");
		String npw = in.nextLine();
		ct.setPass(npw);
		System.out.println("신규 회원의 주소를 입력하세요");
		String naddr = in.nextLine();
		ct.setAddr(naddr);
		// 포인트는 자동 0 으로 시작
		cdao.putcus(ct);

	}
	


	private void menu() {

		System.out.println("회원 관리 시스템");
		System.out.println("1. 신규 고객 등록");
		System.out.println("2. 고객 목록 보기");
		System.out.println("3. 고객 정보 수정");
		System.out.println("4. 고객 정보 삭제");
		System.out.println("5. 고객 정보 검색");
	}

}
