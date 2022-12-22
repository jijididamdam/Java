package extends_ex1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 남자 2, 여자 2 개를 만들려고 한다
		ArrayList<Child_M> cmList = new ArrayList<>();  // 남자 구성원 1개
		ArrayList<Child_W> cwList = new ArrayList<>();  // 여자 구성원 1개 
		Child_M cm1 = new Child_M();
		cm1.name="silverSoo";
		cm1.prt();
		cm1.eatting();		
		Child_M cm2 = new Child_M();
		
		Child_W cw1 = new Child_W();
		cw1.name="womanSoo";
		cw1.prt();
		cw1.eatting();
		Child_W cw2 = new Child_W();
	}

}
