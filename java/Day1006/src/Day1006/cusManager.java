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
		
		System.out.println("�˻��� ȸ���� ���̵� �̸��� �Է��ϼ���");
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
		System.out.println("�˻��� ȸ���� ���̵� �Է��ϼ���");
		String sid = in.nextLine();
		for (int i = 0; i < plist.size(); i++) {
			if (sid.equals(plist.get(i).getId())) {
				plist.get(i).prt();
				return;
			}
		}
		System.out.println("ȸ���� �����ϴ�.");
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("������ ȸ���� ���̵� �Է����ּ���");
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
				cdao.modcus(mid, mname, cal);
			} else if (sel == 2) {
				String cal = "pass";
				System.out.println("���ο� ��й�ȣ�� �Է��ϼ���");
				String mpw = in.nextLine();
				cdao.modcus(mid, mpw, cal);
			} else if (sel == 3) {
				String cal = "addr";
				System.out.println("���ο� �ּҸ� �Է��ϼ���");
				String maddr = in.nextLine();
				cdao.modcus(mid, maddr, cal);
			} else if (sel == 4) {
				String cal = "point";
				System.out.println("���ο� ����Ʈ�� �Է��ϼ���");
				String mpoint = in.nextLine();
				cdao.modcus(mid, mpoint, cal);
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
		System.out.println("3. �ּ� ����");
		System.out.println("4. ����Ʈ ����");

	}

	private void prt() {
		for (cusDTO ct : plist) {
			ct.prt();
		}

	}


	public int replay(String nid) {

		for (int i = 0; i < plist.size(); i++) {
			if (nid.equals(plist.get(i).getId())) {
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
		if (replay(nid) == 1) {
			replay(nid);
		} else {
			set(nid);
		}

	}
	
	private void set(String nid) {
		cusDTO ct = new cusDTO();
		ct.setId(nid);
		System.out.println("�ű� ȸ���� �̸��� �Է��ϼ���");
		String nname = in.nextLine();
		ct.setName(nname);
		System.out.println("�ű� ȸ���� ��й�ȣ�� �Է��ϼ���");
		String npw = in.nextLine();
		ct.setPass(npw);
		System.out.println("�ű� ȸ���� �ּҸ� �Է��ϼ���");
		String naddr = in.nextLine();
		ct.setAddr(naddr);
		// ����Ʈ�� �ڵ� 0 ���� ����
		cdao.putcus(ct);

	}
	


	private void menu() {

		System.out.println("ȸ�� ���� �ý���");
		System.out.println("1. �ű� �� ���");
		System.out.println("2. �� ��� ����");
		System.out.println("3. �� ���� ����");
		System.out.println("4. �� ���� ����");
		System.out.println("5. �� ���� �˻�");
	}

}
