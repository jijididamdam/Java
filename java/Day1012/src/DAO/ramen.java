package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.ramenDTO;

public class ramen implements allDAO {

	Scanner in = new Scanner(System.in);

	ArrayList<ramenDTO> rlist = new ArrayList<>();

	//private String sramen = null;
	//private int ccnt = 0;

	

	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("���� ���� �����ϻ�, ������ ����� �ϼ�");
	}

	@Override
	public void bask() {
		// TODO Auto-generated method stub
		ramenDTO rm = new ramenDTO();
		System.out.println("���� ������� �Է����ּ���");
		System.out.println("* ����� 1500��");
		System.out.println("* ���� 2000��");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("��� �������?");
			int ccel = in.nextInt();
			in.nextLine();
			rm.setSramen(bsel);
			rm.setCcnt(ccel);
			rlist.add(rm);
		}
	}

	public int same(String bsel) {
		if (bsel.equals("�����")) {
			return 1;
		} else if (bsel.equals("����")) {
			return 1;
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			return 2;
		}
	}

	@Override
	public void calc() {
		int sum1 = 0;
		int sum2 = 0;

		// TODO Auto-generated method stub
		for (int i = 0; i < rlist.size(); i++) {
			if ("�����".equals(rlist.get(i).getSramen())) {
				sum1 += rlist.get(i).getCcnt();
			} else {
				sum2 += rlist.get(i).getCcnt();
			}
		}
		System.out.println("�� ����� ���� : " + (sum1 * 1500) + "��");
		System.out.println("�� ���� ���� : " + (sum2 * 2000) + "��");
	}

}
