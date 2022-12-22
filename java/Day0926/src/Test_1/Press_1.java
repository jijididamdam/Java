package Test_1;

import java.util.Scanner;

public class Press_1 {

	Scanner in = new Scanner(System.in);
	int cnt = 0;

	public void put() {
		String word = in.nextLine();
		if (word.length() <= 100) {
			for (int i = 0; i < word.length(); i++) {
				cnt = 0;
				for (int j = i; j < word.length(); j++) {
					if (word.charAt(i) != word.charAt(j)) {
						break;
					} else {
						cnt++;
					}
				}
				if (cnt > 1) {
					i = i + cnt - 1;
				} else {
				}
				System.out.println(i + " : " + word.charAt(i) + "/");
				System.out.println(cnt + " 개가 연속으로 있다.");
				System.out.println();
			}
		}
	}

}
