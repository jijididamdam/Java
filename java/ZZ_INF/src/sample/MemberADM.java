package sample;

import java.util.Scanner;

import dao.*;
import dto.MemberDTO;


public class MemberADM {
	
	Scanner in = new Scanner(System.in);
	DAO_INF nowDao = null;
	
	
	public MemberADM() {
		
		System.out.println("고객의 자료를 저장하겠습니다. 저장할 데이터 베이스 선택");
		System.out.println("원하는 데이터베이스를 선택하세요");
		System.out.println("1. 오라클");
		System.out.println("2. MySQL");
		System.out.println("3. MariaDB");
		System.out.println("4. MongoDB");
		
		int sel = in.nextInt();
		in.nextLine();
		
		if(sel==1) {
			//오라클 저장
			nowDao = new OracleDAO();
		} else if(sel==2) {
			//MySQL 저장
			nowDao = new MySqlDAO();
		} else if(sel==3) {
			// 마리아 디비 저장
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
				//회원등록
				addMember();
			} else if(sel==2) {
				//회원삭제
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
		System.out.println("1. 회원등록");
		System.out.println("2. 회원삭제");
		System.out.println("선택하세요 >>");
	}

}
