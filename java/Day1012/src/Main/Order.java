package Main;

import java.util.ArrayList;
import java.util.Scanner;

import DAO.allDAO;
import DAO.ddockbokki;
import DAO.kimbab;
import DAO.ramen;

public class Order {

	Scanner in = new Scanner(System.in);
	allDAO adao = null;

	public ArrayList<Object> list = new ArrayList<>();

	public Order() {
		
		System.out.println("1. �ֹ��ϱ�");
		System.out.println("2. �ֹ� ���� ����");

		int sel = in.nextInt();
		in.nextLine();

		if (sel == 1) {
			run();
		} else if (sel == 2) {
			adao.calc();
		}
	}

	void run() {
		
		for (;;) {
			
			System.out.println("������ �޴� ����");
			System.out.println("1. ���");
			System.out.println("2. ������");
			System.out.println("3. ���");
			System.out.println("4. �����޴�");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				adao = new ramen();
			} else if (sel == 2) {
				adao = new ddockbokki();
			} else if (sel == 3) {
				adao = new kimbab();
			} else if (sel == 4) {
				return;
			}

			running();
		}
	}

	private void running() {
		for (;;) {
			
			// TODO Auto-generated method stub
			System.out.println("1. ������");
			System.out.println("2. ��ٱ��ϴ��");
			System.out.println("3. ����ϱ�");
			System.out.println("4. ���ư���");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				adao.exp();

			} else if (sel == 2) {
				adao.bask();

			} else if (sel == 3) {
				adao.calc();

			} else if (sel == 4) {				
				return;
			}
		}

	}

	

}
