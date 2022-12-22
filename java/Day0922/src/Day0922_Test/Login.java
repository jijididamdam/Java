package Day0922_Test;

import java.util.Scanner;
/* 1. 로그인 : 아이디 & 비번 입력
 *    - 관리자 로그인 : 관리자의 아이디 & 비번과 일치하면 물건관리(GoodsManager)와 고객관리(MemberManager) 선택하여 정보 관리 가능
 *    - 고객 로그인 : 기존 저장된 고객의 아이디 & 비번과 일치하면 쇼핑하기로 안내        
 * 2. 회원가입 : 고객 정보 입력 - 고객관리(MemberManager)의 고객 등록 메서드로 이동하여 정보 입력하면 자동 저장되어 바로 쇼핑하기로 안내
 * 3. 이전메뉴 : MainMenu로 이동되어 비회원으로 쇼핑하러 갈 수도 있음
 */


public class Login {
	Scanner in = new Scanner(System.in);
	MemberManager ct = null;
	GoodsManager gm = null;
	Shopping sh = null;

	public Login(MemberManager ct, GoodsManager gm, Shopping sh) {
		this.ct = ct;
		this.gm = gm;
		this.sh = sh;
	}

	public void runLogin() {
		for (;;) {
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if(sel == 3) {
				break;
			} else if(sel ==2) {
				Lmenu();
			} else if(sel == 1) {
				lgmenu();
			}
		}

	}

	public void lgmenu() {
		System.out.println("아이디를 입력하세요");
		String Lid = in.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String Lpw = in.nextLine();
		boolean flag = true;
		if (gm.id.equals(Lid) && gm.pw.equals(Lpw)) {
			gmenu(Lid, Lpw);
			flag = false;
		}
		for (int i = 0; i < ct.clist.size(); i++) {
			if (Lid.contains(ct.clist.get(i).id) && Lpw.contains(ct.clist.get(i).pw)) {
				sh.runShop();
				flag = false;
				break;
			}

		}
		if (flag) {
			System.out.println("해당하는 회원이 존재하지 않습니다.");
		}
	}

	public void menu() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 이전메뉴");
	}

	public void gmenu(String Lid, String Lpw) {
		for (;;) {
			if (gm.id.equals(Lid) && gm.pw.equals(Lpw)) {
				System.out.println("1. 물건관리");
				System.out.println("2. 고객관리");
				System.out.println("3. 이전메뉴");
				int sel = in.nextInt();
				in.nextLine();
				if (sel == 1) {
					gm.gmlogin(Lid, Lpw);

				} else if (sel == 2) {
					ct.runclient();

				} else if (sel == 3) {
					break;
				}

			}
		}

	}

	public void Lmenu() {
		ct.addclient();
		sh.runShop();
	}
}
