package sample;

import java.util.Scanner;

import dao.*;
import dto.MemberDTO;


public class MemberADM {
	
	Scanner in = new Scanner(System.in);
	DAO_INF nowDao = null;
	
	
	public MemberADM() {
		
		System.out.println("���� �ڷḦ �����ϰڽ��ϴ�. ������ ������ ���̽� ����");
		System.out.println("���ϴ� �����ͺ��̽��� �����ϼ���");
		System.out.println("1. ����Ŭ");
		System.out.println("2. MySQL");
		System.out.println("3. MariaDB");
		System.out.println("4. MongoDB");
		
		int sel = in.nextInt();
		in.nextLine();
		
		if(sel==1) {
			//����Ŭ ����
			nowDao = new OracleDAO();
		} else if(sel==2) {
			//MySQL ����
			nowDao = new MySqlDAO();
		} else if(sel==3) {
			// ������ ��� ����
			nowDao = new MariaDAO();
		} else if(sel==4) {
			nowDao = new MongoDB();
		}
		
		running();
		
	}
	
	public void running() {
		while(true) {
			menu();
			
			int sel = in.nextInt();
			in.nextLine();
			
			if(sel==1) {
				//ȸ�����
				addMember();
			} else if(sel==2) {
				//ȸ������
				delMember();
			}
		}
	}
	
	
	private void delMember() {
		
		
	}

	private void addMember() {
		MemberDTO m = new MemberDTO();
		nowDao.insert(m);
		
	}

	public void menu() {
		System.out.println("1. ȸ�����");
		System.out.println("2. ȸ������");
		System.out.println("�����ϼ��� >>");
	}

}
