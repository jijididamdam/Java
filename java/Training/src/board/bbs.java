package board;

//import java.util.stream.Stream;

public class bbs {
	String[] badWord = { "������", "�����" };

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
				System.out.println("�Ұ���");
				return 0;
			} else {
				title=w;
				no=n;
				System.out.println("�ٲ�");
				return 1;
			}
		}
	

	public String con(String let) {
		if (title.contains(let)) {
			System.out.println(title + "���� ���Ե� ���ڸ� �߰��߽��ϴ� : " + let);
			return title;
		} else {
			System.out.println("��ġ�ϴ� ���ڰ� �����ϴ�");
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
		System.out.println("������ : " + title);
		System.out.println("�۹�ȣ : " + no);
		System.out.println("�۳��� : " + memo);
		System.out.println("��ȸ�� : " + view);
	}

}
