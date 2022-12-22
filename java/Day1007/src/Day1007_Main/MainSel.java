package Day1007_Main;

import java.util.ArrayList;
import java.util.Scanner;

import Customer.Customer;
import Customer.CustomerADM;
import Customer.CustomerDAO;
import Shopping.Shopping;
import Stock.StockADM;

public class MainSel {
	Scanner in = new Scanner(System.in);
	StockADM sa = new StockADM();
	CustomerADM ca = new CustomerADM();
	CustomerDAO cd = new CustomerDAO();
	Shopping sh = new Shopping();
	ArrayList<Customer> clist = cd.allCus();
	
	MainSel() {
		for(;;) {
			
			System.out.println("1. ������");
			System.out.println("2. ���ǰ���");
			System.out.println("3. �����ϱ�");
			int sel = in.nextInt();
			in.nextLine();
			if(sel==1) {
				ca.runc();
			} else if(sel==2) {
				sa.runStock();
			} else if(sel==3) {
				login();
			}
		}
	}

	private void login() {
		// TODO Auto-generated method stub
		System.out.println("���̵� �Է����ּ���");
		String lid=in.nextLine();
		for(int i = 0; i<clist.size(); i++) {
			if(lid.equals(clist.get(i).getCid())) {
			   System.out.println("��й�ȣ�� �Է����ּ���");
			   String lpw=in.nextLine();
			   if(lpw.equals(clist.get(i).getCpw())) {
				   System.out.println("�α����� �Ϸ�Ǿ����ϴ�.");
				   //�����ϱ�� �Ѿ
				   sh.srun(lid);
			   }
			}
		}
		System.out.println("�α��ο� �����Ͽ����ϴ�.");
		
	}
	
	
	
	
	
	
}
