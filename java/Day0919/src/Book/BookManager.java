package Book;

import java.util.Scanner;

public class BookManager {
	Book[] bList = new Book[10];
	Scanner in = new Scanner(System.in);
	String[] badWord = { "�ٺ�", "��û��", "�˰�", "������" };

	BookManager() {
		// å�� �����ϴ� ��ü : å ���, ����, ����, �˻�, ��ü����
		for (;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				BookInput();
			} else if (selMenu == 2) {
				BookModify();
			} else if (selMenu == 3) {
				del();
			} else if (selMenu == 4) {
				search();
			} else if (selMenu == 5) {
				BookList();
			}
		}
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("�����ϰ� ���� å������ �Է��ϼ���");
		String bname = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			if ((bList[i].name).contains(bname)) {
				System.out.println("�ش��ϴ� å�� ã�ҽ��ϴ�.");
				bList[i].prt();
				System.out.println("���ϴ� å�� ��ȣ�� �Է��ϼ���");
				int cno = in.nextInt();
				in.nextLine();
				if (bList[i].no == cno) {
					bList[i] = null;
				}
				System.out.println("������ �Ϸ��Ͽ����ϴ�");
				break;
			} else {
				System.out.println("�ش��ϴ� å�� �����ϴ�");
				break;
			}
		}
	}

	public void setName(String s) {
		for (int i = 0; i < bList.length; i++) {
			if (badWordCheck(s) == 1) {
				System.out.println("�����մϴ�");
				break;

			} else if (badWordCheck(s) == 0) {
				System.out.println("�弳�� ���ԵǾ� �ֽ��ϴ�");
				break;
			}
		}
	}

	public int badWordCheck(String s) {
		for (int i = 0; i < badWord.length; i++) {
			if (badWord[i].contains(s)) {
				return 0;
			}
		}
		return 1;
	}

	public void choiceName(String s) {
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] != null) {
				if ((bList[i].name).contains(s)) {
					System.out.println("�ش��ϴ� å�� ã�ҽ��ϴ�. : " + bList[i].name);
				}				
			}
			else {
				System.out.println("�ش��ϴ� å�� �����ϴ�");
				if(choiceFull(s)==1) {
					break;
				}				
			}
		}
	}
	
	public int choiceFull(String s) {
		for(int i=0; i < bList.length ; i++) {
			if((bList[i].name).contains(s)&&bList[i]!=null) {
				return 0;
			}			
		}
		return 1;
	}

	private void BookModify() {
		// TODO Auto-generated method stub
		System.out.println("�����ϰ� ���� å ������ �Է��ϼ���");
		String word = in.nextLine();
		choiceName(word);
		System.out.println("� å���� ����ּ��� : �� ������ �Է����ּ���");
		String fullname = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			// if ((bList[i].name).contains(word)) {
			// if (word.equalsIgnoreCase(bList[i].name)) {
			if ((bList[i].name).contains(fullname)) {
				System.out.println("� ������ �����ϰڽ��ϱ�?");
				modList();
				int selMod = in.nextInt();
				in.nextLine();
				if (selMod == 1) {
					System.out.println("���ο� å ������ �Է��ϼ���");
					String newname = in.nextLine();
					if (badWordCheck(newname) == 1) {
						System.out.println("�����մϴ�");
						bList[i].name = newname;
						break;
					} else if (badWordCheck(newname) == 0) {
						System.out.println("�弳���� �Ұ����մϴ�");
						break;
					}
				} else if (selMod == 2) {
					System.out.println("���ο� ������ �Է��ϼ���");
					int newyear = in.nextInt();
					in.nextLine();
					bList[i].year = newyear;
					break;
				} else if (selMod == 3) {
					System.out.println("���ο� �ۼ��ڸ� �Է��ϼ���");
					String newWriter = in.nextLine();
					bList[i].writer = newWriter;
					break;
				}

			}

		}
		System.out.println("������ �Ϸ��Ͽ����ϴ�.");
	}

	private void modList() {
		// TODO Auto-generated method stub
		System.out.println("1. å����");
		System.out.println("2. ����");
		System.out.println("3. �ۼ���");
	}

	private void search() {
		// TODO Auto-generated method stub
		System.out.println("ã�� ���� å ������ �Է��ϼ���");
		String word = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			if (word.equals(bList[i].name)) {
				bList[i].prt();
				break;
			} else {
				System.out.println("�ش��ϴ� å�� �����ϴ�");
				break;
			}
		}
	}

	private void BookList() {
		// TODO Auto-generated method stub
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] != null) {
				System.out.println(i + "���� ����");
				bList[i].prt();
				System.out.println("-------------------------------------");
			}
		}
	}

	private void BookInput() { // �弳�߰�
		// TODO Auto-generated method stub
		// å ��� �߰�
		Book newBook = new Book();
		for (int i = 0; i < bList.length; i++) {

			if (bList[i] == null) {
				System.out.println("å��ȣ�� �Է��ϼ���");
				int no = in.nextInt();
				in.nextLine();
				System.out.println("å�̸��� �Է��ϼ���");
				String name = in.nextLine();
				setName(name);
				if (badWordCheck(name) == 0) {
					break;
				}
				System.out.println("������ �Է��ϼ���");
				int year = in.nextInt();
				in.nextLine();
				System.out.println("�ۼ��ڸ� �Է��ϼ���");
				String writer = in.nextLine();
				newBook.setting(no, name, year, writer);

				bList[i] = newBook;
				break;
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. å���");
		System.out.println("2. å����");
		System.out.println("3. å����");
		System.out.println("4. å�˻�");
		System.out.println("5. ��ü����");

	}

}
