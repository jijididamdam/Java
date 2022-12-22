package Day0922_Test;

import java.util.ArrayList;
import java.util.Scanner;

import Day0922_Test.BasketGoods;

/* ��ȸ�� VS ȸ���� ����� �� �ִ� �޴��� �ٸ�   ~ ��ٱ��ϴ� ȸ�����̵� ������ ��� �Ұ���
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

	// ȸ���� �̿��ϴ� �޴�
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

	// ��ȸ���� �̿��ϴ� �޴�
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
				System.out.println("��ȸ���� ����� �� �����ϴ�.");
			} else if (sel == 4) {
				System.out.println("��ȸ���� ����� �� �����ϴ�.");
			}

		}
	}

	public void blist() {
		// TODO Auto-generated method stub
		System.out.println("ȸ���� ���̵� �Է����ּ���");
		String sid = in.nextLine();
		for (int i = 0; i < slist.size(); i++) {
			if (sid.equals(slist.get(i).id)) {
				slist.get(i).prt();
			}
		}
	}

	/*
	 * ȸ���� �α����� ���Ͽ� �ٷ� �����ϱ�� �����µ� �� ������ ������ �ȵǾ� ��ٱ��ϸ� �̿��Ϸ��� ���̵� �� �� �� �Է��Ͽ� ȸ������
	 * ũ�ν�üũ�� �Ѵ� �� ��, �Էµ� id�� �� ���� ��ǰ ��ٱ���(slist)�� id�� ������ ���ϴ� ������ �̸�(scname)�� �Է��ϸ�
	 * �� �ܾ ���Ե� ������ �̸��� ã���� �� �ܾ ���Ե� ������ �̸� ����Ʈ�� ������ -> ���ϴ� ������ ��ȣ�� �Է����� -> �� ������
	 * �� ���� ��ٱ���(slist)�� �����̸����� ������ ���� ������ �Է� -> �Էµ� ������ ������ �ڵ����� ������ �ش� ������ ������
	 * ����Ͽ� �� �������� ����� �� ������ slist�� ����� ����� ���� ������
	 */

	public void basket() {
		System.out.println("��ٱ��ϸ� �̿��Ϸ��� ȸ���� ���̵� �Է����ּ���");
		String cid = in.nextLine();

		for (int i = 0; i < ct.clist.size(); i++) {
			if (cid.equals(ct.clist.get(i).id)) {
				basket_1();
				return;
			}
		}
		System.out.println("�ش��ϴ� ���̵� ���� ��ٱ��� �̿� �Ұ���");
	}

	public void basket_1() {
		System.out.println("������ �̸��� �Է��ϼ���");
		String scname = in.nextLine();
		for (int i = 0; i < gm.aList.size(); i++) {
			if (gm.aList.get(i).gname.contains(scname)) {
				System.out.println(i + "��°------");
				gm.aList.get(i).prt();
				System.out.println("�ش��ϴ� ������ ��ȣ ������ �Է��ϼ���");
				int no = in.nextInt();
				in.nextLine();
				System.out.println("�� ���� ��ٱ��Ͽ� �������?");
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
					System.out.println("��� �����Ͽ� ��ٱ��� ��� �Ұ���");
					break;
				}
			}

		}

	}

	/*
	 * ��ǰ�����ϸ� ��ϵ� ������ ��� �ڵ����� �پ�� �����Ϸ��� ������ ��ϵ� ������ ����� ������ �����Ͽ� ������ �� ���ٰ� ����
	 */

	public void buy() {
		System.out.println("� ��ǰ�� �����Ͻðڽ��ϱ�?");
		gm.listGoods();
		System.out.println("������ ��ǰ�� ��ȣ�� �Է��ϼ���");
		int no = in.nextInt();
		in.nextLine();
		if (gm.aList.size() > no) {
			System.out.println(gm.aList.get(no).gname);
			System.out.println("�� ��ǰ���� ������ ������ �Է����ּ���");
			int bcnt = in.nextInt();
			in.nextLine();
			if ((gm.aList.get(no).cnt - bcnt) > 0) {
				System.out.println(gm.aList.get(no).gname + " ��ǰ�� " + bcnt + "�� ���ſϷ�");
				gm.aList.get(no).cnt = (gm.aList.get(no).cnt - bcnt);
			} else {
				System.out.println("��� �����Ͽ� ������ �� �����ϴ�.");
			}

		} else {
			System.out.println("�ش��ϴ� ��ǰ�� �����ϴ�.");
		}

	}

	public void menu() {
		System.out.println("1. ��ǰ����");
		System.out.println("2. �����ϱ�");
		System.out.println("3. ��ٱ��� ���");
		System.out.println("4. ȸ���� ��ٱ��� ����Ʈ ����");
		System.out.println("5. �����޴�");
	}

}
