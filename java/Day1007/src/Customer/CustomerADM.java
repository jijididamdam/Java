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

		System.out.println("�˻��� ȸ���� ���̵� �̸��� �Է��ϼ���");
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
		System.out.println("�˻��� ȸ���� ���̵� �Է��ϼ���");
		String sid = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (sid.equals(plist.get(i).getCid())) {
				plist.get(i).cprt();
				return;
			}
		}
		System.out.println("ȸ���� �����ϴ�.");
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("������ ȸ���� ���̵� �Է����ּ���");
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
		System.out.println("������ ���̵� �Է��ϼ���");
		String mid = in.nextLine();
		if (same(mid) == 1) {
			choice();
			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				String cal = "name";
				System.out.println("���ο� �̸��� �Է��ϼ���");
				String mname = in.nextLine();
				cdao.modc(mid, mname, cal);
			} else if (sel == 2) {
				String cal = "pass";
				System.out.println("���ο� ��й�ȣ�� �Է��ϼ���");
				String mpw = in.nextLine();
				cdao.modc(mid, mpw, cal);
			}
		} else {
			System.out.println("��ġ�ϴ� ȸ���� �����ϴ�.");
			return;
		}

	}

	private void choice() {
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���");
		System.out.println("1. �̸� ����");
		System.out.println("2. ��й�ȣ ����");

	}

	private void prt() {
		for (Customer ct : plist) {
			ct.cprt();
		}

	}

	public int replay(String nid) {

		for (int i = 0; i < plist.size(); i++) {
			if (nid.equals(plist.get(i).getCid())) {
				System.out.println("���� ���̵� �ֽ��ϴ�.");
				put();
				return 1;
			}
		}
		return 2;
	}

	private void put() {
		System.out.println("�ű� ȸ���� ���̵� �Է��ϼ���");
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
		System.out.println("�ű� ȸ���� �̸��� �Է��ϼ���");
		String nname = in.nextLine();
		ct.setCname(nname);
		System.out.println("�ű� ȸ���� ��й�ȣ�� �Է��ϼ���");
		String npw = in.nextLine();
		ct.setCpw(npw);
		/*
		 * System.out.println("�ű� ȸ���� �ּҸ� �Է��ϼ���"); String naddr = in.nextLine();
		 * ct.setAddr(naddr);
		 */
		// ����Ʈ�� �ڵ� 0 ���� ����
		cdao.putc(ct);

	}

	private void menu() {

		System.out.println("ȸ�� ���� �ý���");
		System.out.println("1. �ű� �� ���");
		System.out.println("2. �� ��� ����");
		System.out.println("3. �� ���� ����");
		System.out.println("4. �� ���� ����");
		System.out.println("5. �� ���� �˻�");
		System.out.println("6. ���ư���");
	}

}
