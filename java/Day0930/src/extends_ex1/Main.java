package extends_ex1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� 2, ���� 2 ���� ������� �Ѵ�
		ArrayList<Child_M> cmList = new ArrayList<>();  // ���� ������ 1��
		ArrayList<Child_W> cwList = new ArrayList<>();  // ���� ������ 1�� 
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
