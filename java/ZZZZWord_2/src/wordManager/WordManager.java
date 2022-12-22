package wordManager;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Scanner;

import TestCode.WordDAO;
import TestCode.WordInfoDTO;
import word.WordInfo;



public class WordManager {
	//단어 저장, 삭제, 수정, 전체보기
	// WordInfo 객체가 필요합니다..그 객체를 의존하고 있다.
	// 의존이 반드시 필요한 것은 아니다.. 저장할때만 필요하다..
	private WordInfo winfo = null;
	private WordDAO wdao= new WordDAO();
	private Scanner in = new Scanner(System.in);
	//private HashMap<String,WordInfo> wList = new HashMap<>();
	
	public WordManager(){

		
	}
	
	//public HashMap<String, WordInfo> getwList() {
		//return wList;
	//}

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
		/* 절차 키보드로 입력할 것은 없다.
		 * 쿼리 : select * from word1;
		 * select 데이터 조회
		 * listWord()에서 조회한 데이터를 가져와야 한다.(리턴값 받아온다.)
		 */
		
		ArrayList<WordInfoDTO> wordList = wdao.allSelect();
		for(WordInfoDTO w : wordList) {
			w.prt();
		}
		
		
		
	}

	private void modWord() {
		// 공사중
		System.out.println("수정할 영어단어를 입력하세요");
		String mword=in.nextLine();
		choice();
		int sel=in.nextInt();
		in.nextLine();
		if(sel==1) {
			String cword="kor";
			System.out.println("수정할 뜻을 입력하세요");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		} else if(sel==2) {
			String cword="info";
			System.out.println("수정할 중요도를 입력하세요");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		} else if(sel==3) {
			String cword="comm";
			System.out.println("수정할 설명을 입력하세요");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		}
	}

	private void choice() {
		// TODO Auto-generated method stub
		System.out.println("1. 뜻 수정");
		System.out.println("2. 중요도 수정");
		System.out.println("3. 설명 수정");
	}

	private void delWord() {
		//공사중 
		System.out.println("삭제할 영어단어를 입력하세요");
		String dword = in.nextLine();
		System.out.println("테이블명을 입력해주세요");
		String tname = in.nextLine();
		wdao.delWord(dword,tname);
	}

	private void addWord() {
		WordInfoDTO ww = new WordInfoDTO();		
		System.out.println("단어추가 -----");
		System.out.println("key로 사용할 영어 단어 입력하세요");
		String keyWord = in.nextLine();
		ww.setEngName(keyWord);
		System.out.println("Value 중 한글 단어의 의미를 입력하세요");
		String valueKorWord = in.nextLine();
		ww.setKorName(valueKorWord);
		System.out.println("Value 중  중요도를 입력하세요");
		String valueimporWord = in.nextLine();
		ww.setImporFlag(valueimporWord);
		System.out.println("Value 중 설명 입력하세요");
		String valuecommetkeyWord = in.nextLine();
		ww.setComment(valuecommetkeyWord);
		wdao.insertWord(ww);
		

		
		
	//	winfo.setComment(valuecommetkeyWord);
	//	winfo.setImporFlag(valueimporWord);
		//winfo.setKorName(valueKorWord);
		
		//wList.put(keyWord, winfo);
		
	}

	private void menu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 전체보기");
		System.out.println("5. 종료");
	}

}
