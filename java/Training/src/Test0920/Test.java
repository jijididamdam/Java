package Test0920;

import java.util.ArrayList;

public class Test {
	//Test용 클래스
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 객체를 여러개 만들었고..이 객체를 하나의 변수로 핸들링하기 위해서 배열을 사용했다
		 * 배열의 특징 : 연속적인 공간, 순서가 있다, 선언된 배열의 크기를 변경하기 힘들다(단점)
		 *      		방법 : 사이즈, 인덱스(0부터 시작한다)
		 * 자바개발에서는 ArrayList 자료형을 많이 사용한다.
		 * List의 하위개념이 ArrayList 일반적으로 자바에서는 List라고 많이 이야기한다.
		 * List의 특징 : 연속공간, 순서가 있다, 크기가 유동적이다, 사용하는 만큼이다, 사용하기 더 편하다
		 * 				방법 : 사이즈, 인덱스(0부터 시작한다)
		 * 
		 * 실제 면접에서 배열과 List의 특징은 단골질문이다.
		 * 
		 */
		
		//선언
		Member[] mlist1=new Member[10];
		ArrayList<Member> mlist2 = new ArrayList<>();  // ctrl + shift + o
		//ArrayList<name> mlist3 = new ArrayList<>();
		System.out.println(mlist1.length);   // 10
		System.out.println(mlist2.size());   // 0
		
		//입력 . 배열
		Member m1 = new Member("kim",23);
		Member m2 = new Member("lee",23);
		for(int i=0; i < mlist1.length; i++) {
			if(mlist1[i]==null) {
				mlist1[i]=m1;   // 배열에 값을 저장하는 것..우리가 사용한 for은 빈칸을 찾는 것이였다
				break;
			}
		}
		//입력 . ArrayList  
		mlist2.add(m1); // index 0
		
		// 값 가져오기. 배열
		for(int i=0; i < mlist1.length; i++) {
			if(mlist1[i]!=null) {
				mlist1[i].prt();
			}
		}
		
		// 값 가져오기. 리스트
		for(int i=0; i < mlist2.size(); i++) {
			mlist2.get(i).prt();
		}
		
		// 값 가져오기 list만 설명
		mlist2.add(m2); // index 1
		mlist2.add(m2); // index 2
		mlist2.get(0);   // 리턴된 주소를 무시
		Member mm = mlist2.get(0); // 리턴된 주소를 m의 값에 저장하겠다. 대입
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
