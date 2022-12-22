package Word;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E_Word {

	Scanner in = new Scanner(System.in);
	private Map<String, Hash> map = new HashMap<>();
	
	Map<String, Hash> mget() {
		return map;
	}
	
	 
	void E_Word() {
		for (;;) {
			menu();
			int sellist = in.nextInt();
			in.nextLine();
			if (sellist == 1) {
				input();
			} else if (sellist == 2) {
				del();
				;
			} else if (sellist == 3) {
				mod();
			} else if (sellist == 4) {
				prt();
			} else if (sellist == 5) {
				sch();
			} else if (sellist == 6) {
				break;
			}
		}
		
	}
	

	void sch() {
		// TODO Auto-generated method stub
		System.out.println("검색할 영어 단어를 입력해주세요");
		String sword = in.nextLine();
		for (String key : map.keySet()) {
			if (sword.equals(key)) {
				System.out.println("영어단어 : " + key );
				map.get(key).prt();
				return;
			}
		}
		System.out.println("해당하는 단어가 없습니다.");
	}

	void prt() {
		// TODO Auto-generated method stub
		System.out.println("등록된 단어의 수 : "+map.size()+"개");
		for (String key : map.keySet()) {
			System.out.println("영어 단어 : "+ key);
			map.get(key).prt();

		}
	}

	void mod() {
		// TODO Auto-generated method stub
		System.out.println("수정할 단어를 입력해주세요");
		String sword = in.nextLine();
		for (String key : map.keySet()) {
			if (key.equals(sword)) {
				System.out.println("영어단어 : " + key);
				System.out.println("수정 할 부분의 숫자를 선택해주세요.");
				System.out.print("1. 영어단어");
				System.out.print("2. 뜻");
				System.out.println("3. 설명");
				System.out.println("*등급은 자동 판별로 수정할 수 없습니다.*");
				int sel = in.nextInt();
				in.nextLine();
				if (sel == 1) {
					System.out.println("새로운 영어단어를 입력해주세요");
					String mword = in.nextLine();
					if (over(mword) == 1) {
						System.out.println("중복된 영어 단어가 있습니다.");
						return;
					} else {
						map.put(mword, map.get(key));
						map.remove(key, map.get(key));
						System.out.println("수정을 완료하였습니다.");
						return;
					}
				} else if (sel == 2) {
					System.out.println("새로운 단어의 뜻을 입력해주세요");
					String mword = in.nextLine();
					map.get(key).input(mword,map.get(key).getComment(),map.get(key).getGrade());
					System.out.println("수정을 완료하였습니다.");
					return;
				} else if (sel==3) {
					System.out.println("새로운 설명을 입력해주세요");
					String cword = in.nextLine();
					map.get(key).input(map.get(key).getWord(),cword,map.get(key).getGrade());
					System.out.println("수정을 완료하였습니다.");
				}

			}
		}
		System.out.println("해당하는 단어가 없습니다.");
	}
	

	public int over(String k) {
		for (String key : map.keySet()) {
			if (key.equals(k)) {
				return 1;
			}
		}
		return 0;
	}

	void input() {
		Hash hh = new Hash();
		System.out.println("영어단어를 입력하세요");
		String eword = in.nextLine();
		if (over(eword) == 1) {
			System.out.println("중복된 영어 단어가 있습니다.");
			return;
		} else {
			System.out.println("뜻을 입력하세요.");
			String kword = in.nextLine();
			System.out.println("설명을 입력하세요");
			String cword = in.nextLine();
			// 영어 단어의 문자열 길이가 8이상이면 상
			// 					 5이상이면 중
			//					  그 이하면 하
			if (eword.length()>=8) {
				hh.input(kword,cword,"상");
				map.put(eword, hh);
				System.out.print("상 등급으로 ");
			} else if (eword.length() >= 4&& eword.length()<8) {
				hh.input(kword,cword,"중");
				map.put(eword, hh);
				System.out.print("중 등급으로 ");
			} else {
				hh.input(kword,cword,"하");
				map.put(eword, hh);
				System.out.print("하 등급으로 ");
			}
			System.out.println("입력이 완료되었습니다.");
		}

	}


	void del() {
		System.out.println("삭제할 영어단어를 입력하세요");
		String dword = in.nextLine();
		for (String key : map.keySet()) {
			if (key.equals(dword)) {
				map.remove(key);
				System.out.println("삭제가 완료되었습니다.");
				return;
			}
		}
		System.out.println("해당하는 단어가 없습니다.");

	}

	void menu() {
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 전체보기");
		System.out.println("5. 단어 검색");
		System.out.println("6. 이전 메뉴");
	}

}

