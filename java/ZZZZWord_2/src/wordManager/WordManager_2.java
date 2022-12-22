package wordManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import word.WordInfo;

public class WordManager_2 {

	// 단어 저장, 삭제, 수정, 전체보기
	// WordInfo 객체가 필요합니다..그 객체를 의존하고 있다.
	// 의존이 반드시 필요한 것은 아니다.. 저장할때만 필요하다..
	private WordInfo winfo = null;
	private Scanner in = new Scanner(System.in);
	// private HashMap<String,WordInfo> wList = new HashMap<>();

	// public HashMap<String, WordInfo> getwList() {
//	      return wList;
	// }

	private Connection conn = null;

	public WordManager_2() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("로드 실패");
		}
	}

	public void wordManagerRun() {
		// for(;;) {
		while (true) {
			menu();
			System.out.println("선택 >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				addWord();
			} else if (selMenu == 2) {
				delWord();
			} else if (selMenu == 3) {
				modWord();
			} else if (selMenu == 4) {
				listWord();
			} else {
				break;
			}

		}
	}

	private void listWord() {
//	      System.out.println("-- 등록된 단어 목록 -- ("+wList.size()+")");
//	      for(String keyinfo : wList.keySet()) {
//	         System.out.println("<단어정보> "+keyinfo);
//	         WordInfo temp = wList.get(keyinfo);
//	         temp.prt();
//	         System.out.println("----------------------");
//	      }
	}

	private void modWord() {
		// 공사중
	}

	private void delWord() {
		// 공사중
	}

	public boolean connect() {
		try {
			// 커넥션을 시도하고 그 결과를 얻어 오는 코드...
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			System.out.println("연결실패");
			return false;
		}
	}

	private void addWord() {
//	      지금 샘플을 참고하여 단어를 데이터 베이스에 저장하도록 코딩
		if (connect()) {
			WordInfo w = new WordInfo();
			System.out.println("영단어를 입력하세요");
			String engName = in.nextLine();
			w.setEngName(engName);
			System.out.println("뜻을 입력하세요");
			String korName = in.nextLine();
			w.setKorName(korName);
			System.out.println("코멘트를 입력하세요");
			String comment = in.nextLine();
			w.setComment(comment);
			System.out.println("중요도를 입력하세요");
			String impo = in.nextLine();
			w.setImporFlag(impo);
			//w.prt();
			String sql = "insert into word1 values(?,?,?,?,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);

				psmt.setString(1, w.getEngName());
				//System.out.println(w.getEngName());
				psmt.setString(2, w.getKorName());
				psmt.setString(3, w.getComment());
				psmt.setString(4, w.getImporFlag());
				// System.out.println(psmt);
				int r = psmt.executeUpdate();
				conn.close();
				System.out.println("입력완료");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void menu() {
		System.out.println("1. 추가");
		System.out.println("2. 삭제");
		System.out.println("3. 수정");
		System.out.println("4. 전체보기");
		System.out.println("5. 종료");
	}

//	      winfo = new WordInfo();      
//	      System.out.println("단어추가 -----");
//	      System.out.println("key로 사용할 영어 단어 입력하세요");
//	      String keyWord = in.nextLine();
//	      System.out.println("Value 중 한글 단어의 의미를 입력하세요");
//	      String valueKorWord = in.nextLine();
//	      System.out.println("Value 중  중요도를 입력하세요");
//	      String valueimporWord = in.nextLine();
//	      System.out.println("Value 중 설명 입력하세요");
//	      String valuecommetkeyWord = in.nextLine();
//	      winfo.setComment(valuecommetkeyWord);
//	      winfo.setImporFlag(valueimporWord);
//	      winfo.setKorName(valueKorWord);
//	      wList.put(keyWord, winfo);
}
