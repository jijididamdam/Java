package Day0922_Test;

import java.util.ArrayList;
import java.util.Scanner;

import Day0922_Test.BasketGoods;

/* 비회원 VS 회원이 사용할 수 있는 메뉴가 다름   ~ 장바구니는 회원아이디 없으면 사용 불가능
 */

public class Shopping {
	Scanner in = new Scanner(System.in);
	ArrayList<BasketGoods> slist = new ArrayList<>();
	GoodsManager gm = null;
	MemberManager ct = null;

	public Shopping(GoodsManager gm, MemberManager ct) {
		this.gm = gm;
		this.ct = ct;
	}

	// 회원이 이용하는 메뉴
	public void runShop() {
		for (;;) {
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				gm.listGoods();
			} else if (sel == 2) {
				buy();
			} else if (sel == 5) {
				break;
			} else if (sel == 3) {
				basket();
			} else if (sel == 4) {
				blist();
			}

		}
	}

	// 비회원이 이용하는 메뉴
	public void x_runShop() {
		for (;;) {
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				gm.listGoods();
			} else if (sel == 2) {
				buy();
			} else if (sel == 5) {
				break;
			} else if (sel == 3) {
				System.out.println("비회원은 사용할 수 없습니다.");
			} else if (sel == 4) {
				System.out.println("비회원은 사용할 수 없습니다.");
			}

		}
	}

	public void blist() {
		// TODO Auto-generated method stub
		System.out.println("회원의 아이디를 입력해주세요");
		String sid = in.nextLine();
		for (int i = 0; i < slist.size(); i++) {
			if (sid.equals(slist.get(i).id)) {
				slist.get(i).prt();
			}
		}
	}

	/*
	 * 회원은 로그인을 통하여 바로 쇼핑하기로 들어오는데 이 정보가 저장이 안되어 장바구니를 이용하려면 아이디를 한 번 더 입력하여 회원인지
	 * 크로스체크를 한다 이 때, 입력된 id를 그 고객의 상품 장바구니(slist)의 id로 저장함 원하는 물건의 이름(scname)을 입력하면
	 * 그 단어가 포함된 물건의 이름을 찾아줌 그 단어가 포함된 물건의 이름 리스트를 보여줌 -> 원하는 물건의 번호를 입력해줌 -> 이 정보를
	 * 그 고객의 장바구니(slist)의 물건이름으로 저장함 고객이 수량을 입력 -> 입력된 수량을 저장함 자동으로 수량과 해당 물건의 가격을
	 * 계산하여 총 가격으로 저장됨 위 정보로 slist에 저장됨 저장된 정보 보여줌
	 */

	public void basket() {
		System.out.println("장바구니를 이용하려면 회원의 아이디를 입력해주세요");
		String cid = in.nextLine();

		for (int i = 0; i < ct.clist.size(); i++) {
			if (cid.equals(ct.clist.get(i).id)) {
				basket_1();
				return;
			}
		}
		System.out.println("해당하는 아이디가 없어 장바구니 이용 불가능");
	}

	public void basket_1() {
		System.out.println("물건의 이름을 입력하세요");
		String scname = in.nextLine();
		for (int i = 0; i < gm.aList.size(); i++) {
			if (gm.aList.get(i).gname.contains(scname)) {
				System.out.println(i + "번째------");
				gm.aList.get(i).prt();
				System.out.println("해당하는 물건의 번호 순서를 입력하세요");
				int no = in.nextInt();
				in.nextLine();
				System.out.println("몇 개를 장바구니에 담을까요?");
				int ccnt = in.nextInt();
				in.nextLine();
				if ((gm.aList.get(no).cnt - ccnt) > 0) {
					boolean cf = true;
					for (int j = 0; j < slist.size(); j++) {
						if (ct.clist.get(i).id.equals(slist.get(j).id)) {
							slist.get(j).buycnt += ccnt;
							cf = false;
							break;
						} else {
							break;
						}
					}
					if (cf) {
						BasketGoods put = new BasketGoods(ct, gm);
						int sum = (gm.aList.get(no).price) * ccnt;
						String gn = gm.aList.get(no).gname;
						put.setting(ct.clist.get(i).id, gn, ccnt, sum);
						slist.add(put);
					}
				} else {
					System.out.println("재고가 부족하여 장바구니 담기 불가능");
					break;
				}
			}

		}

	}

	/*
	 * 상품구매하면 등록된 물건의 재고 자동으로 줄어듬 구매하려는 수량이 등록된 물건의 재고보다 많으면 부족하여 구매할 수 없다고 나옴
	 */

	public void buy() {
		System.out.println("어떤 상품을 구매하시겠습니까?");
		gm.listGoods();
		System.out.println("구매할 상품의 번호를 입력하세요");
		int no = in.nextInt();
		in.nextLine();
		if (gm.aList.size() > no) {
			System.out.println(gm.aList.get(no).gname);
			System.out.println("이 상품으로 구매할 수량을 입력해주세요");
			int bcnt = in.nextInt();
			in.nextLine();
			if ((gm.aList.get(no).cnt - bcnt) > 0) {
				System.out.println(gm.aList.get(no).gname + " 상품을 " + bcnt + "개 구매완료");
				gm.aList.get(no).cnt = (gm.aList.get(no).cnt - bcnt);
			} else {
				System.out.println("재고가 부족하여 구매할 수 없습니다.");
			}

		} else {
			System.out.println("해당하는 상품이 없습니다.");
		}

	}

	public void menu() {
		System.out.println("1. 상품보기");
		System.out.println("2. 구매하기");
		System.out.println("3. 장바구니 담기");
		System.out.println("4. 회원의 장바구니 리스트 보기");
		System.out.println("5. 이전메뉴");
	}

}
