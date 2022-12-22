package board;

//import java.util.stream.Stream;

public class bbs {
	String[] badWord = { "개나리", "십장생" };

	String title = null;
	int no = 0;
	String memo = null;
	int view = 0;
	
	

	public int bad(String w,int n) {
		int index=0;
		for(int i=0; i<2; i++) {
		index = badWord[i].indexOf(w);
		//System.out.println(index);
		}
			if(index <=0) {
				System.out.println("불가능");
				return 0;
			} else {
				title=w;
				no=n;
				System.out.println("바꿈");
				return 1;
			}
		}
	

	public String con(String let) {
		if (title.contains(let)) {
			System.out.println(title + "에서 포함된 문자를 발견했습니다 : " + let);
			return title;
		} else {
			System.out.println("일치하는 문자가 없습니다");
			return null;
		}

	}

	public void save(String t, int n, String m) {
		title = t;
		no = n;
		memo = m;
	}

	public int vinc(int v) {
		for (int i = 0; i <= v; i++) {
			view++;
		}
		System.out.println(view);
		return view;
	}

	public String rti() {
		return title;
	}

	public int rno() {
		return no;
	}

	public String rme() {
		return memo;
	}

	public int rvi() {
		return view;
	}

	public void prt() {
		System.out.println("글제목 : " + title);
		System.out.println("글번호 : " + no);
		System.out.println("글내용 : " + memo);
		System.out.println("조회수 : " + view);
	}

}
