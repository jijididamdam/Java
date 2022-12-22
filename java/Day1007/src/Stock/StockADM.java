package Stock;

import java.util.ArrayList;
import java.util.Scanner;

public class StockADM {

	Scanner in = new Scanner(System.in);
	StockDAO sdao = new StockDAO();
	ArrayList<Stock> slist = sdao.all();

	public void runStock() {
		for (;;) {
			System.out.println("1. ���ǵ��");
			System.out.println("2. ���Ǽ���");
			System.out.println("3. ���ǻ���");
			System.out.println("4. ���ǰ˻�");
			System.out.println("5. ����м� ");
			System.out.println("6. ���ư���");

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
		System.out.println("�˻��� ������ ���̵� �Է��ϼ���");
		String sid = in.nextLine();
		for (int i = 0; i < slist.size(); i++) {
			if (sid.equals(slist.get(i).getSid())) {
				slist.get(i).sprt();
				return;
			}
		}
		System.out.println("������ �����ϴ�.");
	}

	private void sdel() {
		// TODO Auto-generated method stub
		System.out.println("������ ������ ���̵� �Է��ϼ���");
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
		System.out.println("������ ������ ���̵� �Է��ϼ���");
		String mid = in.nextLine();
		if (same(mid) == 1) {
			System.out.println("������ �׸��� ������.");
			System.out.println("1. �����̸�");
			System.out.println("2. ���");
			System.out.println("3. ����");
			System.out.println("4. �Ǹ����̸�");
			System.out.println("5. �԰�¥");

			int sel = in.nextInt();
			in.nextLine();
			if (sel == 1) {
				String cal = "sname";
				System.out.println("���ο� ������ �̸��� �Է��ϼ���.");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 2) {
				String cal = "scnt";
				System.out.println("��� ������ �����ұ��?");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 3) {
				String cal = "sprice";
				System.out.println("���� ������ �����ұ��?");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 4) {
				String cal = "pname";
				System.out.println("���ο� �Ǹ��ڸ� �Է��ϼ���");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			} else if (sel == 5) {
				String cal = "dt";
				System.out.println("���ο� ��¥�� �Է��ϼ���");
				String mval = in.nextLine();
				sdao.mods(mid, mval, cal);
			}
		}

	}

	private void sput() {
		Stock st = new Stock();
		System.out.println("���ο� ������ ���̵� �Է��ϼ���");
		String nid = in.nextLine();
		st.setSid(nid);
		System.out.println("���ο� ������ �̸��� �Է��ϼ���");
		String nname = in.nextLine();
		st.setSname(nname);
		System.out.println("���ο� ������ ��� �Է��ϼ���");
		int ncnt = in.nextInt();
		in.nextLine();
		st.setScnt(ncnt);
		System.out.println("���ο� ������ ������ �Է��ϼ���");
		int nprice = in.nextInt();
		in.nextLine();
		st.setSprice(nprice);
		System.out.println("���ο� ������ �Ǹ��ڸ� �Է��ϼ���");
		String npname = in.nextLine();
		st.setPname(npname);
		sdao.putS(st);
		System.out.println("�Է¿Ϸ�");
	}

}
