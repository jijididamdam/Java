package Market;

import java.util.ArrayList;
import java.util.Scanner;

public class Member {

	Scanner in= new Scanner(System.in);
	ArrayList<Goods> basket = new ArrayList<>();
	Array_GoodsManager gm2 = null;
	String name = "Guest";
	//�������� ������ �����ϵ��� Ȯ��
	/*String id = null;
	 * int point=0;
	 * String addr=null;
	 */
	public Member(Array_GoodsManager gm2) {
		this.gm2=gm2;
	}
	
	public void goShopping() {
		for(;;) {
			System.out.println("1. �����ϱ�");
			System.out.println("2. ��ٱ���");
			System.out.println("3. �����޴�");
			int selMenu = in. nextInt();
			in.nextLine();
			if(selMenu==1) {
				shopping();
			} else if (selMenu==2) {
				viewBasket();
			} else if (selMenu==3) {
				break;
			}
		}
	}
	//�ڵ� 5�ٷ� �����ϱ� > �����ϱ� ������ ������ ����� �߰� �϶�
	
	
	private void viewBasket() {
		// TODO Auto-generated method stub
		// ��ȣ �����ؼ� ��ٱ��Ͽ� �ش� ���� �ּ� ����
				/*System.out.println("��ȣ�� �����Ͻÿ�");
				int no = in.nextInt();
				in.nextLine();					
				basket.add(gm2.aList.get(no));
				for(int i=0; i< basket.size();i++) {
					basket.get(i).prt();
				}*/
		//�̸����� �˻��ؼ� ��ٱ��Ͽ� �ش� �̸��� ���� �߰�
		int ccnt=1;
		System.out.println("������ �̸��� �Է��ϼ���");
		String scname = in.nextLine();
		for(int i=0; i<gm2.aList.size(); i++) {

			if(gm2.aList.get(i).name.contains(scname)) {
				Goods input = new Goods();
				input.setting(scname, gm2.aList.get(i).id, ccnt, gm2.aList.get(i).price);
				basket.add(input);
				
			}
			
		}
		
		for(int i=0; i< basket.size();i++) {
			basket.get(i).prt();
		}
		
		
		
	}

	public void shopping() {
		//System.out.println("���� ������");
		/*
		 * 1. ������ ����Ʈ����
		 * 2. ���� �����ϱ�
		 * 3. �ڽ��� ��ٱ��Ͽ� ���
		 */		
		gm2.listGoods();
		
		
		
	}

}