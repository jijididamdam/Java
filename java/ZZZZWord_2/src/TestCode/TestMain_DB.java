package TestCode;

import wordManager.WordManager;

public class TestMain_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WordManager wm = new WordManager();
		//wm.wordManagerRun();
		//단어정보를 만들고 이것을 입력
		/*String eng="cat";
		String kor="고양이";
		String impor="중";
		String comment="명사";
		
		WordInfoDTO w = new WordInfoDTO();
		
		위의 단어를 디비에 저장하려고 한다. 이 때 DAO insert메서드 호출이 필요하다.
		insert 메서드에서는 쿼리가 insert into word1 values(?,?,?,?,default)
		호출부에서 ? ? ? ? 의 정보를 알려줘야한다.
		그런데 insert 메서드는 이 정보를 매개변수로 받는다... 그리고 이 매개변수는 DTO로 정의되어 있다.
		그래서 DTO 객체를 만들고 정보를 입력하고 매개변수로 넘겨준다.
		
		
		w.setEngName(eng);
		w.setKorName(kor);
		w.setImporFlag(impor);
		w.setComment(comment);
		wdao.insertWord(w);
		*/
		WordManager mm = new WordManager();
		mm.wordManagerRun();
		
	}

}
