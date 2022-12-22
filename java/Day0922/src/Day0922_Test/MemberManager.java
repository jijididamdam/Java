package Day0922_Test;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {

	ArrayList<Member> clist = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	// 아이디 중복 불가

	MemberManager() {
		// TODO Auto-generated constructor stub

	}

	public void runclient() {
		for (;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				addclient();
			} else if (selMenu == 3) {
				listclient();
			} else if (selMenu == 2) {
				modclient();
			} else if (selMenu == 4) {
				delclient();
			} else if (selMenu == 5) {
				searchclient();
			} else if (selMenu == 6) {
				break;
			}
		}
	}

	// 동명이인도 출력

	private void searchclient() {
		// TODO Auto-generated method stub
		System.out.println("검색할 고객의 이름을 입력하세요");
		String sname = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).cname.contains(sname)) {
				clist.get(i).prt();
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("해당하는 이름이 없습니다.");
		}
	}

	// 동명이인 출력 - 해당하는 번호로 삭제

	private void delclient() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 고객의 이름을 입력하세요");
		String dname = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).cname.contains(dname)) {
				System.out.println(i + "번째------");
				clist.get(i).prt();
				System.out.println("삭제할 고객의 번호순서를 입력하세요");
				int no = in.nextInt();
				in.nextLine();
				clist.remove(no);
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("해당하는 이름이 없습니다.");
		} else {
			System.out.println("수정을 완료하였습니다.");
		}

	}

	// 정보수정 - 새로운 아이디 입력할 때, 기존에 있는 아이디와 같다면 입력 불가능 단, 다시 입력할 1번의 기회만 추가 제공 2번째부터는
	// 수정메소드에서 빠져나옴
	// point 증감도 여기서 지정해주어야함

	private void modclient() {
		// TODO Auto-generated method stub
		System.out.println("수정할 고객의 이름을 입력하세요");
		String mname = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).cname.contains(mname)) {
				System.out.println(i + "번째------");
				clist.get(i).prt();
				System.out.println("수정할 고객의 번호순서를 입력하세요");
				int no = in.nextInt();
				in.nextLine();
				modmenu();
				int selMenu = in.nextInt();
				in.nextLine();
				if (selMenu == 1) {
					System.out.println("새로운 이름을 입력해주세요");
					String modname = in.nextLine();
					clist.get(no).cname = modname;
					flag = false;
					break;
				} else if (selMenu == 2) {
					System.out.println("새로운 아이디를 입력해주세요"); // 아이디 중복 안됨
					String modid = in.nextLine();
					if (same(modid) == 1) {
						System.out.println("다른 아이디를 입력해주세요");
						modid = in.nextLine();
					}
					if (same(modid) == 2) {
						clist.get(no).id = modid;
						flag = false;
						break;
					}
				} else if (selMenu == 4) {
					System.out.println("포인트를 수정해주세요");
					int modPoint = in.nextInt();
					in.nextLine();
					clist.get(no).point = modPoint;
					flag = false;
					break;
				} else if (selMenu == 3) {
					System.out.println("비밀번호를 수정해주세요");
					String modpw = in.nextLine();
					clist.get(no).pw = modpw;
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("해당하는 이름이 없습니다.");
		} else {
			System.out.println("수정을 완료하였습니다.");
		}

	}

	// 중복 아이디 확인
	public int same(String s) {
		for (int i = 0; i < clist.size(); i++) {
			if (s.equals(clist.get(i).id)) {
				System.out.println("같은 아이디가 있습니다.");
				return 1;
			}
		}
		return 2;
	}

	public void modmenu() {
		System.out.println("원하는 정보수정을 골라주세요");
		System.out.println("1. 고객의 이름 변경");
		System.out.println("2. 고객의 아이디 변경");
		System.out.println("3. 고객의 비밀번호 변경");
		System.out.println("4. 고객의 포인트 수정");
	}

	public void listclient() {
		// TODO Auto-generated method stub
		for (int i = 0; i < clist.size(); i++) {
			System.out.println(i + "번째------");
			clist.get(i).prt();
			System.out.println("------------");
		}
	}

	// 신규 고객 등록은 고객 이름, 아이디, 비번만 입력 ~ point는 자동으로 0 값이 들어감
	public void addclient() {
		Member put = new Member();
		System.out.println("고객의 이름을 입력하세요");
		String cname = in.nextLine();
		System.out.println("고객의 아이디를 입력하세요");
		String id = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (same(id) == 1) {
				flag = false;
				break;
			} else {
				flag=true;
			}
		}
		if (flag == true) {
			System.out.println("고객의 비밀번호를 입력하세요");
			String pw = in.nextLine();
			int point = 0;
			put.setting(cname, id, pw, point);
			clist.add(put);
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 고객 신규 등록");
		System.out.println("2. 고객 정보 수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 고객 삭제");
		System.out.println("5. 검색하기");
		System.out.println("6. 이전메뉴");
	}

}
