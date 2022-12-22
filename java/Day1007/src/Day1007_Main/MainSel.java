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
			
			System.out.println("1. 고객관리");
			System.out.println("2. 물건관리");
			System.out.println("3. 쇼핑하기");
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
		System.out.println("아이디를 입력해주세요");
		String lid=in.nextLine();
		for(int i = 0; i<clist.size(); i++) {
			if(lid.equals(clist.get(i).getCid())) {
			   System.out.println("비밀번호를 입력해주세요");
			   String lpw=in.nextLine();
			   if(lpw.equals(clist.get(i).getCpw())) {
				   System.out.println("로그인이 완료되었습니다.");
				   //쇼핑하기로 넘어감
				   sh.srun(lid);
			   }
			}
		}
		System.out.println("로그인에 실패하였습니다.");
		
	}
	
	
	
	
	
	
}
