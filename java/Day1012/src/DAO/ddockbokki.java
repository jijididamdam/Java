package DAO;

import java.util.Scanner;

import DTO.ddockbokkiDTO;
import Main.Order;

public class ddockbokki implements allDAO {

	Scanner in = new Scanner(System.in);
	
	ddockbokkiDTO dt = null;
	
	Order od = new Order();
	
	



	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("���� ������ �ϳ� �� �������� ��������");
	}

	@Override
	public void bask() {
		
		ddockbokkiDTO dk = new ddockbokkiDTO();
		System.out.println("�� ���� ���� : �Ҷ�, �ж�");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("�ʱ� ���� ���� : �� , �߰� , ����");
			String mcel = in.nextLine();
			if (sm(mcel) == 3) {
				System.out.println("���κ�? 1�κп� 2000���Դϴ�.");
				int ccel = in.nextInt();
				in.nextLine();
				dk.setSddoc(bsel);
				dk.setLevel(mcel);
				dk.setCcnt(ccel);
				od.list.add(dk);
			}
		}
	}

	public int same(String bsel) {
		if (bsel.equals("�Ҷ�")) {
			return 1;
		} else if (bsel.equals("�ж�")) {
			return 1;
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return 2;
		}
	}

	public int sm(String msel) {
		if (msel.equals("��")) {
			return 3;
		} else if (msel.equals("�߰�")) {
			return 3;
		} else if (msel.equals("����")) {
			return 3;
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return 4;
		}
	}

	@Override
	public void calc() {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 0; i < od.list.size(); i++) {
			sum+=od.list.;
		}
		System.out.println("�� ������ ���� : "+(sum*2000)+"��");
	}

}
