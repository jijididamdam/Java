package Test0920;

import java.util.ArrayList;

public class Test {
	//Test�� Ŭ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ��ü�� ������ �������..�� ��ü�� �ϳ��� ������ �ڵ鸵�ϱ� ���ؼ� �迭�� ����ߴ�
		 * �迭�� Ư¡ : �������� ����, ������ �ִ�, ����� �迭�� ũ�⸦ �����ϱ� �����(����)
		 *      		��� : ������, �ε���(0���� �����Ѵ�)
		 * �ڹٰ��߿����� ArrayList �ڷ����� ���� ����Ѵ�.
		 * List�� ���������� ArrayList �Ϲ������� �ڹٿ����� List��� ���� �̾߱��Ѵ�.
		 * List�� Ư¡ : ���Ӱ���, ������ �ִ�, ũ�Ⱑ �������̴�, ����ϴ� ��ŭ�̴�, ����ϱ� �� ���ϴ�
		 * 				��� : ������, �ε���(0���� �����Ѵ�)
		 * 
		 * ���� �������� �迭�� List�� Ư¡�� �ܰ������̴�.
		 * 
		 */
		
		//����
		Member[] mlist1=new Member[10];
		ArrayList<Member> mlist2 = new ArrayList<>();  // ctrl + shift + o
		//ArrayList<name> mlist3 = new ArrayList<>();
		System.out.println(mlist1.length);   // 10
		System.out.println(mlist2.size());   // 0
		
		//�Է� . �迭
		Member m1 = new Member("kim",23);
		Member m2 = new Member("lee",23);
		for(int i=0; i < mlist1.length; i++) {
			if(mlist1[i]==null) {
				mlist1[i]=m1;   // �迭�� ���� �����ϴ� ��..�츮�� ����� for�� ��ĭ�� ã�� ���̿���
				break;
			}
		}
		//�Է� . ArrayList  
		mlist2.add(m1); // index 0
		
		// �� ��������. �迭
		for(int i=0; i < mlist1.length; i++) {
			if(mlist1[i]!=null) {
				mlist1[i].prt();
			}
		}
		
		// �� ��������. ����Ʈ
		for(int i=0; i < mlist2.size(); i++) {
			mlist2.get(i).prt();
		}
		
		// �� �������� list�� ����
		mlist2.add(m2); // index 1
		mlist2.add(m2); // index 2
		mlist2.get(0);   // ���ϵ� �ּҸ� ����
		Member mm = mlist2.get(0); // ���ϵ� �ּҸ� m�� ���� �����ϰڴ�. ����
		Member mm1 = mlist2.get(1);
		System.out.println(mlist2.get(0));
		System.out.println(mlist2.get(1));
		System.out.println(mlist2.get(2));
		

		mlist2.get(1).name="park";
		System.out.println("---------------------");
		for(int i=0; i < mlist2.size(); i++) {
			mlist2.get(i).prt();
		}
		
		
		
	}

}
