package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.kimbabDTO;

public class kimbab implements allDAO {

	Scanner in = new Scanner(System.in);

	ArrayList<kimbabDTO> klist = new ArrayList<>();



	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("�������� ������ ��������");
	}

	@Override
	public void bask() {
		// TODO Auto-generated method stub
		
		kimbabDTO kb = new kimbabDTO();

		System.out.println("���� ����Դϱ�?");
		System.out.println("��  �� ���  2000��");
		System.out.println("��  ġ ���  3000��");
		System.out.println("��� ���  3000��");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("�� �� �ұ��?");
			int csel = in.nextInt();
			in.nextLine();

			kb.setSkim(bsel);
			kb.setCcnt(csel);

			klist.add(kb);
		}
	}

	public int same(String bsel) {
		if (bsel.equals("��ġ")) {
			return 1;
		} else if (bsel.equals("�Ϲ�")) {
			return 1;
		} else if (bsel.equals("���")) {
			return 1;
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return 2;
		}
	}

	@Override
	public void calc() {
		// TODO Auto-generated method stub
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(int i = 0; i < klist.size(); i++) {
			if("��ġ".equals(klist.get(i).getSkim())) {
				sum1+=klist.get(i).getCcnt();
			} else if("�Ϲ�".equals(klist.get(i).getSkim())) {
				sum2+=klist.get(i).getCcnt();
			} else if("���".equals(klist.get(i).getSkim())) {
				sum3+=klist.get(i).getCcnt();
			}
		}
		System.out.println("��  �� ��� ��"+sum2+"�� "+(sum2*2000)+"��");
		System.out.println("��  ġ ��� ��"+sum1+"�� "+(sum1*3000)+"��");
		System.out.println("��� ��� ��"+sum3+"�� "+(sum3*3000)+"��");
	}

}
