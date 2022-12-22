package Shopping;

import java.util.ArrayList;
import java.util.Scanner;

import Customer.Customer;
import Customer.CustomerDAO;
import Stock.Stock;
import Stock.StockDAO;

public class Shopping {

	Scanner in = new Scanner(System.in);
	CustomerDAO cdao = new CustomerDAO();
	ArrayList<Customer> plist = cdao.allCus();
	StockDAO sdao = new StockDAO();
	ArrayList<Stock> slist = sdao.all();
	ShoppingDAO shdao = new ShoppingDAO();
	ArrayList<ShoppingDTO> shlist = new ArrayList<>();

	public void srun(String lid) {
		for (;;) {
			System.out.println("1. 물건 보기");
			System.out.println("2. 구매하기");
			System.out.println("3. 장바구니");

			int sel = in.nextInt();
			in.nextLine();

			if (sel == 1) {
				shprt();
			} else if (sel == 2) {
				shbuy(lid);
			} else if (sel == 3) {
				shbasket(lid);
			}

		}
	}

	String same(String lid) {
		for (int i = 0; i < plist.size(); i++) {
			if (lid.equals(plist.get(i).getCid())) {
				return lid;
			}
		}
		return null;
	}

	void shbasket(String lid) {
		if (same(lid) == lid) {
			ShoppingDTO shdto = new ShoppingDTO();
			System.out.println("장바구니에 담을 물건의 이름을 입력하세요");
			String fname = in.nextLine();
			for (int j = 0; j < slist.size(); j++) {
				if (slist.get(j).getSname().contains(fname)) {
					//slist.get(j).sprt();
					//System.out.println("장바구니에 담을 물건의 아이디를 입력하세요");
					String fsid = slist.get(j).getSid();
					System.out.println("장바구니에 담을 물건의 수량을 입력하세요");
					int fccnt = in.nextInt();
					in.nextLine();
					
					int sprice = slist.get(j).getSprice()*fccnt;
					String sdt = slist.get(j).getDate();
										
					shdto.setCid(lid);
					shdto.setSid(fsid);
					shdto.setCnt(fccnt);
					shdto.setCprice(sprice);
					shdto.setCdt(sdt);
					shlist.add(shdto);
				}
			}
		} else {
			System.out.println("일치하는 회원이 없습니다.");
		}
	}

	void shbuy(String lid) {
		if (same(lid) == lid) {
			System.out.println("구매할 물건의 이름을 입력하세요");
			String fname = in.nextLine();
			for (int j = 0; j < slist.size(); j++) {
				if (slist.get(j).getSname().contains(fname)) {
					slist.get(j).sprt();
					System.out.println("구매할 물건의 아이디를 입력하세요");
					String fsid = in.nextLine();
					System.out.println("구매할 물건의 수량을 입력하세요");
					int fccnt = in.nextInt();
					in.nextLine();
					
					int sprice = slist.get(j).getSprice()*fccnt;
					String sdt = slist.get(j).getDate();
					
					shdao.putsh(lid, fsid, fccnt, sprice, sdt);
				}
			}
		} else {
			System.out.println("일치하는 회원이 없습니다.");
		}
	}

	void shprt() {
		// TODO Auto-generated method stub
		for (Stock st : slist) {
			st.sprt();
		}
	}

}
