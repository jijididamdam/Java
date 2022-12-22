package Word;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E_Word {

	Scanner in = new Scanner(System.in);
	private Map<String, Hash> map = new HashMap<>();
	
	Map<String, Hash> mget() {
		return map;
	}
	
	 
	void E_Word() {
		for (;;) {
			menu();
			int sellist = in.nextInt();
			in.nextLine();
			if (sellist == 1) {
				input();
			} else if (sellist == 2) {
				del();
				;
			} else if (sellist == 3) {
				mod();
			} else if (sellist == 4) {
				prt();
			} else if (sellist == 5) {
				sch();
			} else if (sellist == 6) {
				break;
			}
		}
		
	}
	

	void sch() {
		// TODO Auto-generated method stub
		System.out.println("�˻��� ���� �ܾ �Է����ּ���");
		String sword = in.nextLine();
		for (String key : map.keySet()) {
			if (sword.equals(key)) {
				System.out.println("����ܾ� : " + key );
				map.get(key).prt();
				return;
			}
		}
		System.out.println("�ش��ϴ� �ܾ �����ϴ�.");
	}

	void prt() {
		// TODO Auto-generated method stub
		System.out.println("��ϵ� �ܾ��� �� : "+map.size()+"��");
		for (String key : map.keySet()) {
			System.out.println("���� �ܾ� : "+ key);
			map.get(key).prt();

		}
	}

	void mod() {
		// TODO Auto-generated method stub
		System.out.println("������ �ܾ �Է����ּ���");
		String sword = in.nextLine();
		for (String key : map.keySet()) {
			if (key.equals(sword)) {
				System.out.println("����ܾ� : " + key);
				System.out.println("���� �� �κ��� ���ڸ� �������ּ���.");
				System.out.print("1. ����ܾ�");
				System.out.print("2. ��");
				System.out.println("3. ����");
				System.out.println("*����� �ڵ� �Ǻ��� ������ �� �����ϴ�.*");
				int sel = in.nextInt();
				in.nextLine();
				if (sel == 1) {
					System.out.println("���ο� ����ܾ �Է����ּ���");
					String mword = in.nextLine();
					if (over(mword) == 1) {
						System.out.println("�ߺ��� ���� �ܾ �ֽ��ϴ�.");
						return;
					} else {
						map.put(mword, map.get(key));
						map.remove(key, map.get(key));
						System.out.println("������ �Ϸ��Ͽ����ϴ�.");
						return;
					}
				} else if (sel == 2) {
					System.out.println("���ο� �ܾ��� ���� �Է����ּ���");
					String mword = in.nextLine();
					map.get(key).input(mword,map.get(key).getComment(),map.get(key).getGrade());
					System.out.println("������ �Ϸ��Ͽ����ϴ�.");
					return;
				} else if (sel==3) {
					System.out.println("���ο� ������ �Է����ּ���");
					String cword = in.nextLine();
					map.get(key).input(map.get(key).getWord(),cword,map.get(key).getGrade());
					System.out.println("������ �Ϸ��Ͽ����ϴ�.");
				}

			}
		}
		System.out.println("�ش��ϴ� �ܾ �����ϴ�.");
	}
	

	public int over(String k) {
		for (String key : map.keySet()) {
			if (key.equals(k)) {
				return 1;
			}
		}
		return 0;
	}

	void input() {
		Hash hh = new Hash();
		System.out.println("����ܾ �Է��ϼ���");
		String eword = in.nextLine();
		if (over(eword) == 1) {
			System.out.println("�ߺ��� ���� �ܾ �ֽ��ϴ�.");
			return;
		} else {
			System.out.println("���� �Է��ϼ���.");
			String kword = in.nextLine();
			System.out.println("������ �Է��ϼ���");
			String cword = in.nextLine();
			// ���� �ܾ��� ���ڿ� ���̰� 8�̻��̸� ��
			// 					 5�̻��̸� ��
			//					  �� ���ϸ� ��
			if (eword.length()>=8) {
				hh.input(kword,cword,"��");
				map.put(eword, hh);
				System.out.print("�� ������� ");
			} else if (eword.length() >= 4&& eword.length()<8) {
				hh.input(kword,cword,"��");
				map.put(eword, hh);
				System.out.print("�� ������� ");
			} else {
				hh.input(kword,cword,"��");
				map.put(eword, hh);
				System.out.print("�� ������� ");
			}
			System.out.println("�Է��� �Ϸ�Ǿ����ϴ�.");
		}

	}


	void del() {
		System.out.println("������ ����ܾ �Է��ϼ���");
		String dword = in.nextLine();
		for (String key : map.keySet()) {
			if (key.equals(dword)) {
				map.remove(key);
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("�ش��ϴ� �ܾ �����ϴ�.");

	}

	void menu() {
		System.out.println("1. �ܾ� �߰�");
		System.out.println("2. �ܾ� ����");
		System.out.println("3. �ܾ� ����");
		System.out.println("4. �ܾ� ��ü����");
		System.out.println("5. �ܾ� �˻�");
		System.out.println("6. ���� �޴�");
	}

}

