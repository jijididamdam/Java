package Day15_1;

import java.util.Scanner;

public class numADM {
	//��. Ű����� ���ڸ� 5���� �Է� �޾� �̸� �迭�� �����ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
	int [] ran = new int [5];
	Scanner in = new Scanner(System.in);
	
	numADM() {
		list();
	}
	public void list() {
		for(;;) {
			System.out.println("1. ���ڸ� �Է��ϼ���");
			System.out.println("2. ����� ���ڸ� �����ּ���");
			
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
		System.out.println("� ����?");
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
