package Day15_1;

import java.util.Scanner;

public class numADM {
	//가. 키보드로 숫자를 5개를 입력 받아 이를 배열에 저장하고 출력하는 프로그램을 작성하시오
	int [] ran = new int [5];
	Scanner in = new Scanner(System.in);
	
	numADM() {
		list();
	}
	public void list() {
		for(;;) {
			System.out.println("1. 숫자를 입력하세요");
			System.out.println("2. 저장된 숫자를 보여주세요");
			
			int selList = in.nextInt();
			in.nextLine();
			if(selList==1) {
				input();
			}else {
				prt();
			}
		}
	}
	
	public void input() {
		System.out.println("어떤 숫자?");
		int num=in.nextInt();
		in.nextLine();
		for(int i=0; i < ran.length; i++) {
			if(ran[i]==0) {
				ran[i]=num;
				break;
			}
		}
	}
	
	public void prt() {
		for(int i=0; i < ran.length; i++) {
			System.out.println(ran[i]);
		}
	}
	
}
