package wordManager;

import java.util.HashMap;
import java.util.Scanner;

import word.WordInfo;

public class WordManager {
	//단어 저장, 삭제, 수정, 전체보기
	// WordInfo 객체가 필요합니다..그 객체를 의존하고 있다.
	// 의존이 반드시 필요한 것은 아니다.. 저장할때만 필요하다..
	private WordInfo winfo = null;
	private Scanner in = new Scanner(System.in);
	private HashMap<String,WordInfo> wList = new HashMap<>();
	
	public WordManager(){
		
	}
	
	public HashMap<String, WordInfo> getwList() {
		return wList;
	}

	public void wordManagerRun() {
	//	for(;;) {
		while(true) {
			menu();
			System.out.println("선택 >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addWord();
			}else if(selMenu==2) {
				delWord();
			}else if(selMenu==3) {
				modWord();
			}else if(selMenu==4) {
				listWord();
			}else {
				break;
			}
			
		}
	}
	private void listWord() {
		System.out.println("-- 등록된 단어 목록 -- ("+wList.size()+")");
		for(String keyinfo : wList.keySet()) {
			System.out.println("<단어정보> "+keyinfo);
			WordInfo temp = wList.get(keyinfo);
			temp.prt();
			System.out.println("----------------------");
		}
	}

	private void modWord() {
		// 공사중
	}

	private void delWord() {
		// 공사중
	}

	private void addWord() {
		winfo = new WordInfo();		
		System.out.println("단어추가 -----");
		System.out.println("key로 사용할 영어 단어 입력하세요");
		String keyWord = in.nextLine();
		System.out.println("Value 중 한글 단어의 의미를 입력하세요");
		String valueKorWord = in.nextLine();
	//	System.out.println("Value 중  중요도를 입력하세요");
	//	String valueimporWord = in.nextLine();
	//	System.out.println("Value 중 설명 입력하세요");
	//	String valuecommetkeyWord = in.nextLine();
	//	winfo.setComment(valuecommetkeyWord);
	//	winfo.setImporFlag(valueimporWord);
		winfo.setKorName(valueKorWord);
		
		wList.put(keyWord, winfo);
		
	}

	private void menu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 전체보기");
		System.out.println("5. 종료");
	}

}
