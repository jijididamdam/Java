package Word;

import java.util.Scanner;

public class Guide {
	
	Scanner in = new Scanner(System.in);
	E_Word ew = new E_Word();
	Game gm = new Game(ew);
	
	Guide() {
		for(;;) {
			System.out.println("1. �ܾ� ����");
			System.out.println("2. �ܾ� �����ϱ�");
			int sel = in.nextInt();
			in.nextLine();
			if(sel==1) {
				ew.E_Word();
			} else if(sel==2) {
				gm.run();
			}
			
		}
	}

}
