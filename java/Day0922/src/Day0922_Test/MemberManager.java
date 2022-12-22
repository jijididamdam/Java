package Day0922_Test;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {

	ArrayList<Member> clist = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	// ���̵� �ߺ� �Ұ�

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

	// �������ε� ���

	private void searchclient() {
		// TODO Auto-generated method stub
		System.out.println("�˻��� ���� �̸��� �Է��ϼ���");
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
			System.out.println("�ش��ϴ� �̸��� �����ϴ�.");
		}
	}

	// �������� ��� - �ش��ϴ� ��ȣ�� ����

	private void delclient() {
		// TODO Auto-generated method stub
		System.out.println("������ ���� �̸��� �Է��ϼ���");
		String dname = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).cname.contains(dname)) {
				System.out.println(i + "��°------");
				clist.get(i).prt();
				System.out.println("������ ���� ��ȣ������ �Է��ϼ���");
				int no = in.nextInt();
				in.nextLine();
				clist.remove(no);
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("�ش��ϴ� �̸��� �����ϴ�.");
		} else {
			System.out.println("������ �Ϸ��Ͽ����ϴ�.");
		}

	}

	// �������� - ���ο� ���̵� �Է��� ��, ������ �ִ� ���̵�� ���ٸ� �Է� �Ұ��� ��, �ٽ� �Է��� 1���� ��ȸ�� �߰� ���� 2��°���ʹ�
	// �����޼ҵ忡�� ��������
	// point ������ ���⼭ �������־����

	private void modclient() {
		// TODO Auto-generated method stub
		System.out.println("������ ���� �̸��� �Է��ϼ���");
		String mname = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).cname.contains(mname)) {
				System.out.println(i + "��°------");
				clist.get(i).prt();
				System.out.println("������ ���� ��ȣ������ �Է��ϼ���");
				int no = in.nextInt();
				in.nextLine();
				modmenu();
				int selMenu = in.nextInt();
				in.nextLine();
				if (selMenu == 1) {
					System.out.println("���ο� �̸��� �Է����ּ���");
					String modname = in.nextLine();
					clist.get(no).cname = modname;
					flag = false;
					break;
				} else if (selMenu == 2) {
					System.out.println("���ο� ���̵� �Է����ּ���"); // ���̵� �ߺ� �ȵ�
					String modid = in.nextLine();
					if (same(modid) == 1) {
						System.out.println("�ٸ� ���̵� �Է����ּ���");
						modid = in.nextLine();
					}
					if (same(modid) == 2) {
						clist.get(no).id = modid;
						flag = false;
						break;
					}
				} else if (selMenu == 4) {
					System.out.println("����Ʈ�� �������ּ���");
					int modPoint = in.nextInt();
					in.nextLine();
					clist.get(no).point = modPoint;
					flag = false;
					break;
				} else if (selMenu == 3) {
					System.out.println("��й�ȣ�� �������ּ���");
					String modpw = in.nextLine();
					clist.get(no).pw = modpw;
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("�ش��ϴ� �̸��� �����ϴ�.");
		} else {
			System.out.println("������ �Ϸ��Ͽ����ϴ�.");
		}

	}

	// �ߺ� ���̵� Ȯ��
	public int same(String s) {
		for (int i = 0; i < clist.size(); i++) {
			if (s.equals(clist.get(i).id)) {
				System.out.println("���� ���̵� �ֽ��ϴ�.");
				return 1;
			}
		}
		return 2;
	}

	public void modmenu() {
		System.out.println("���ϴ� ���������� ����ּ���");
		System.out.println("1. ���� �̸� ����");
		System.out.println("2. ���� ���̵� ����");
		System.out.println("3. ���� ��й�ȣ ����");
		System.out.println("4. ���� ����Ʈ ����");
	}

	public void listclient() {
		// TODO Auto-generated method stub
		for (int i = 0; i < clist.size(); i++) {
			System.out.println(i + "��°------");
			clist.get(i).prt();
			System.out.println("------------");
		}
	}

	// �ű� �� ����� �� �̸�, ���̵�, ����� �Է� ~ point�� �ڵ����� 0 ���� ��
	public void addclient() {
		Member put = new Member();
		System.out.println("���� �̸��� �Է��ϼ���");
		String cname = in.nextLine();
		System.out.println("���� ���̵� �Է��ϼ���");
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
			System.out.println("���� ��й�ȣ�� �Է��ϼ���");
			String pw = in.nextLine();
			int point = 0;
			put.setting(cname, id, pw, point);
			clist.add(put);
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. �� �ű� ���");
		System.out.println("2. �� ���� ����");
		System.out.println("3. ��ü����");
		System.out.println("4. �� ����");
		System.out.println("5. �˻��ϱ�");
		System.out.println("6. �����޴�");
	}

}
