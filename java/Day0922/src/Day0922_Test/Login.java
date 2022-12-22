package Day0922_Test;

import java.util.Scanner;
/* 1. �α��� : ���̵� & ��� �Է�
 *    - ������ �α��� : �������� ���̵� & ����� ��ġ�ϸ� ���ǰ���(GoodsManager)�� ������(MemberManager) �����Ͽ� ���� ���� ����
 *    - �� �α��� : ���� ����� ���� ���̵� & ����� ��ġ�ϸ� �����ϱ�� �ȳ�        
 * 2. ȸ������ : �� ���� �Է� - ������(MemberManager)�� �� ��� �޼���� �̵��Ͽ� ���� �Է��ϸ� �ڵ� ����Ǿ� �ٷ� �����ϱ�� �ȳ�
 * 3. �����޴� : MainMenu�� �̵��Ǿ� ��ȸ������ �����Ϸ� �� ���� ����
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
		System.out.println("���̵� �Է��ϼ���");
		String Lid = in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���");
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
			System.out.println("�ش��ϴ� ȸ���� �������� �ʽ��ϴ�.");
		}
	}

	public void menu() {
		System.out.println("1. �α���");
		System.out.println("2. ȸ������");
		System.out.println("3. �����޴�");
	}

	public void gmenu(String Lid, String Lpw) {
		for (;;) {
			if (gm.id.equals(Lid) && gm.pw.equals(Lpw)) {
				System.out.println("1. ���ǰ���");
				System.out.println("2. ������");
				System.out.println("3. �����޴�");
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
