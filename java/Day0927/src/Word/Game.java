package Word;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	Scanner in = new Scanner(System.in);
	E_Word ew = null;
	// private ArrayList<String> list = new ArrayList<>();
	private HashMap<String, Wrong> save = new HashMap<>();
	private int xx = 1;
	private int cnt = 0;
	private String[] list = null;

	Game(E_Word ew) {
		this.ew = ew;
	}

	void run() {

		/*
		 * int ccnt=0; for (String kk : ew.mget().keySet()) {
		 * list[ccnt]=ew.mget().get(kk).getWord(); ccnt++; }
		 */
		// list.add(kk.getWord());
		putList();
		System.out.println("������ �����մϴ�.");
		for (int i = 0; i < list.length; i++) {
			int k = (int) (Math.random() * list.length);
			String sword = list[k];
			
			int t = (int) (Math.random() * sword.length());
			String star = String.valueOf(sword.charAt(t));
			int a = (int) (Math.random() * sword.length());
			char Star = sword.charAt(a);
			String rword = sword.replace(star, "*");
			//rword = sword.replace(Star, "*");
			System.out.println("�� : " + rword);
			

			System.out.println("���� �ܾ �Է��ϼ���");
			String qword = in.nextLine();
			for (String key : ew.mget().keySet()) {
				if (qword.equals(key) && sword.equals(ew.mget().get(key).getWord())) {
					cnt += 10;
				} else {
					if (list[k].equals(ew.mget().get(key).getWord())) {
						// save.add(key);
						// Ű ���� ������
						Wrong wr = new Wrong();
						if (save.containsKey(key)) {
							xx = save.get(key).getX();
							xx++;
							wr.input(xx, save.get(key).getA() + ", " + qword);
							save.replace(key, wr);
							break;
						} else {
							wr.input(xx, qword);
							save.put(key, wr);
							break;
						}

					}

				}
			}
		}
		System.out.println("���� : " + cnt);
		if (save != null) {
			for (String key : save.keySet()) {
				System.out.println("Ʋ�� �ܾ� : " + key);
				save.get(key).prt();
			}
		} else {
			System.out.println("��� �����Դϴ�.");
		}
	}

	void putList() {
		list = new String[ew.mget().size()];
		int ccnt = 0;
		for (String kk : ew.mget().keySet()) {
			list[ccnt] = ew.mget().get(kk).getWord();
			ccnt++;
		}
	}

	/*
	 * void run_1() { for (Map.Entry<String, Hash> mm : ew.mget().entrySet()) { if
	 * (mm.getKey().equals(qword)) { cnt += 10; } else { save.put(mm.getKey(),
	 * mm.getValue()); } }
	 * 
	 * // String k=mm.getValue().getWord(); }
	 */

}
