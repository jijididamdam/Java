package Book;

import java.util.Scanner;

public class BookManager {
	Book[] bList = new Book[10];
	Scanner in = new Scanner(System.in);
	String[] badWord = { "바보", "멍청이", "똥개", "말미잘" };

	BookManager() {
		// 책을 관리하는 객체 : 책 등록, 수정, 삭제, 검색, 전체보기
		for (;;) {
			menu();
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				BookInput();
			} else if (selMenu == 2) {
				BookModify();
			} else if (selMenu == 3) {
				del();
			} else if (selMenu == 4) {
				search();
			} else if (selMenu == 5) {
				BookList();
			}
		}
	}

	private void del() {
		// TODO Auto-generated method stub
		System.out.println("삭제하고 싶은 책제목을 입력하세요");
		String bname = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			if ((bList[i].name).contains(bname)) {
				System.out.println("해당하는 책을 찾았습니다.");
				bList[i].prt();
				System.out.println("원하는 책의 번호를 입력하세요");
				int cno = in.nextInt();
				in.nextLine();
				if (bList[i].no == cno) {
					bList[i] = null;
				}
				System.out.println("삭제를 완료하였습니다");
				break;
			} else {
				System.out.println("해당하는 책이 없습니다");
				break;
			}
		}
	}

	public void setName(String s) {
		for (int i = 0; i < bList.length; i++) {
			if (badWordCheck(s) == 1) {
				System.out.println("가능합니다");
				break;

			} else if (badWordCheck(s) == 0) {
				System.out.println("욕설이 포함되어 있습니다");
				break;
			}
		}
	}

	public int badWordCheck(String s) {
		for (int i = 0; i < badWord.length; i++) {
			if (badWord[i].contains(s)) {
				return 0;
			}
		}
		return 1;
	}

	public void choiceName(String s) {
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] != null) {
				if ((bList[i].name).contains(s)) {
					System.out.println("해당하는 책을 찾았습니다. : " + bList[i].name);
				}				
			}
			else {
				System.out.println("해당하는 책이 없습니다");
				if(choiceFull(s)==1) {
					break;
				}				
			}
		}
	}
	
	public int choiceFull(String s) {
		for(int i=0; i < bList.length ; i++) {
			if((bList[i].name).contains(s)&&bList[i]!=null) {
				return 0;
			}			
		}
		return 1;
	}

	private void BookModify() {
		// TODO Auto-generated method stub
		System.out.println("수정하고 싶은 책 제목을 입력하세요");
		String word = in.nextLine();
		choiceName(word);
		System.out.println("어떤 책인지 골라주세요 : 총 제목을 입력해주세요");
		String fullname = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			// if ((bList[i].name).contains(word)) {
			// if (word.equalsIgnoreCase(bList[i].name)) {
			if ((bList[i].name).contains(fullname)) {
				System.out.println("어떤 정보를 수정하겠습니까?");
				modList();
				int selMod = in.nextInt();
				in.nextLine();
				if (selMod == 1) {
					System.out.println("새로운 책 제목을 입력하세요");
					String newname = in.nextLine();
					if (badWordCheck(newname) == 1) {
						System.out.println("가능합니다");
						bList[i].name = newname;
						break;
					} else if (badWordCheck(newname) == 0) {
						System.out.println("욕설포함 불가능합니다");
						break;
					}
				} else if (selMod == 2) {
					System.out.println("새로운 연도를 입력하세요");
					int newyear = in.nextInt();
					in.nextLine();
					bList[i].year = newyear;
					break;
				} else if (selMod == 3) {
					System.out.println("새로운 작성자를 입력하세요");
					String newWriter = in.nextLine();
					bList[i].writer = newWriter;
					break;
				}

			}

		}
		System.out.println("수정을 완료하였습니다.");
	}

	private void modList() {
		// TODO Auto-generated method stub
		System.out.println("1. 책제목");
		System.out.println("2. 연도");
		System.out.println("3. 작성자");
	}

	private void search() {
		// TODO Auto-generated method stub
		System.out.println("찾고 싶은 책 제목을 입력하세요");
		String word = in.nextLine();
		for (int i = 0; i < bList.length; i++) {
			if (word.equals(bList[i].name)) {
				bList[i].prt();
				break;
			} else {
				System.out.println("해당하는 책이 없습니다");
				break;
			}
		}
	}

	private void BookList() {
		// TODO Auto-generated method stub
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] != null) {
				System.out.println(i + "번의 정보");
				bList[i].prt();
				System.out.println("-------------------------------------");
			}
		}
	}

	private void BookInput() { // 욕설추가
		// TODO Auto-generated method stub
		// 책 등록 추가
		Book newBook = new Book();
		for (int i = 0; i < bList.length; i++) {

			if (bList[i] == null) {
				System.out.println("책번호를 입력하세요");
				int no = in.nextInt();
				in.nextLine();
				System.out.println("책이름을 입력하세요");
				String name = in.nextLine();
				setName(name);
				if (badWordCheck(name) == 0) {
					break;
				}
				System.out.println("연도를 입력하세요");
				int year = in.nextInt();
				in.nextLine();
				System.out.println("작성자를 입력하세요");
				String writer = in.nextLine();
				newBook.setting(no, name, year, writer);

				bList[i] = newBook;
				break;
			}
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 책등록");
		System.out.println("2. 책수정");
		System.out.println("3. 책삭제");
		System.out.println("4. 책검색");
		System.out.println("5. 전체보기");

	}

}
