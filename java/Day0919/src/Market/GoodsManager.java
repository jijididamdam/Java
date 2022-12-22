package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsManager {
	Goods[] gList = new Goods[10]; // �����ڷ����� �ʱⰪ�� null�̴�
	ArrayList<Goods> aList = new ArrayList<>();
	Scanner in = new Scanner(System.in);

	// Goods newGoods = new Goods(); ~ ���� ���𹮿� ������ �ϳ��� ��ü�� ������� ������ �Է��ص� �� ���� ��ü�� ���
	// �����Ǵ� ���� (�߰�X)
	GoodsManager() {
		// ������ �����ϴ� ��ü : ���� ���, ����, ����, ���� 1��
		for (;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				addGoods();
			} else if (selMenu == 3) {
				listGoods();
			} else if (selMenu == 2) {
				modGoods();
			} else if (selMenu == 4) {
				delGoods();
			} else if (selMenu == 5) {
				searchGoods();
			}
		}
	}

	private void searchGoods() {
		// �̸����� �˻��Ѵ�. �� �̸��� ����ũ�ϴ�.
		// ���� 1. �̸��� ������ ��ġ�ϸ� -> ���ڿ� ��ü���� � �޼��� Ȱ���ұ�?  		  equals
		// ���� 2. �˻��̸��� �����̸��� ���ԵǸ� -> ���ڿ� ��ü���� � �޼��带 Ȱ���ұ�?    indexOf,  contains
		System.out.println("�˻��� �̸��� �Է��ϼ���");
		String modName=in.nextLine();
		for(int i=0;i<gList.length;i++) {
			if(gList[i]!=null) {
				//����1. �̸��� ����ũ�ϰ� ��ġ�ϴ�...���̻� ��ȸ�� ������ ����.
				if(gList[i].name.equals(modName)) {
					gList[i].prt();
					break;
				}
				// ����2. �̸��� ���ԵǴ� �� ��ȸ�ؾ� �Ѵ�,
				if(gList[i].name.contains(modName)) {
					gList[i].prt();
					//break; 40�� ������ ����
				}
			}
		}
	}

	private void delGoods() {
		// �̸����� �˻��Ͽ� �����Ѵ�.
		System.out.println("������ �̸��� �Է��ϼ���");
		String modName = in.nextLine();
		for(int i=0; i <gList.length; i++) {
			if(gList[i]!=null) {
				if(gList[i].name.equals(modName)) {
					gList[i]=null;
					System.out.println(modName+"�����Ϸ�");
					break;
				}
			}
		}
		
	}

	private void modGoods() {
		// �̸����� �����Ͻÿ� ... �̸����� �����ϴµ� �����ϰ� ���ݸ� ������ �����ϴ�
		System.out.println("������ �̸��� �Է��ϼ���");
		String modName = in.nextLine();
		boolean flag = true;
		for (int i = 0; i < gList.length; i++) {
			if (gList[i] != null) {
				if (gList[i].name.equals(modName)) {
					System.out.println("������ �Է��ϼ���");
					int newInt = in.nextInt();
					in.nextLine();
					gList[i].cnt = newInt;

					System.out.println("������ �Է��ϼ���");
					newInt = in.nextInt();
					in.nextLine();
					gList[i].price = newInt;
					flag = false;
					break;
				}
			}
		}
		if (flag) {
			System.out.println("�̸��� �����ϴ�.");
		}
	}

	private void addGoods() { // �����߰�
		// TODO Auto-generated method stub
		Goods newGoods = new Goods(); // ������ �߰��� ������ ��ü�� ����� ~ ���⿡ �ۼ��ؾ� ���� ��ü ������� // �迭 �����޶� �ּҰ� ������ ��ü ������
		System.out.println("�̸� �Է�");
		String name = in.nextLine();
		System.out.println("���̵��Է�");
		String id = in.nextLine();
		System.out.println("�����Է�");
		int cnt = in.nextInt();
		in.nextLine();
		System.out.println("�����Է�");
		int price = in.nextInt();
		in.nextLine();
		newGoods.setting(name, id, cnt, price);

		for (int i = 0; i < gList.length; i++) {
			if (gList[i] == null) {
				gList[i] = newGoods; // ��ü�� �ּҰ� ���� ~ ��ü ������ �ƴ�
				break;
			}
		}
	}

	private void listGoods() {
		// TODO Auto-generated method stub
		for (int i = 0; i < gList.length; i++) {
			if (gList[i] != null) {
				System.out.println(i + " �� ���� ------");
				gList[i].prt();
				System.out.println("----------------");
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. ���ǵ��");
		System.out.println("2. ���Ǽ���");
		System.out.println("3. ��ü����");
		System.out.println("4. ���ǻ���");
	}

}
