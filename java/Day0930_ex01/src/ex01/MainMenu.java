package ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	CarADM ca = null;
	
	 MainMenu() {
		
		 ca = new CarADM();
			//CarManager scm = new SoCar();
			//CarManager jcm = new JungCar();
			//CarManager dcm = new DaeCar();
			//ArrayList<CarManager> clist = new ArrayList<>();
		for(;;) {
			menu();
			int sel = in.nextInt();
			in.nextLine();
			if(sel==1) {
				ca.setCar();
								
			} else if(sel==2) {
					
			}
			
		}
	}
	


	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. �ڵ������");
		System.out.println("2. ���������ü���");
		System.out.println("3. �ڵ�����ȸ");
	}
	
	
	
}
