package TestCode;

public class WordInfoDTO {
	private String engName=null;
	private String korName=null;
	private String imporFlag=null;
	private String comment=null;
	// 최근 3번 나왔을때 정보를 저장
	private int[] checkFlag = new int[3];
	private int missCnt=0;
	
	
	public void prt() {
		System.out.println("영어단어 : "+engName);
		System.out.println("한글의미 : "+korName);
		System.out.println("중요도 : "+imporFlag);
		System.out.println("설명 : "+comment);
		System.out.println("틀린 수 : "+missCnt);
	}
	
	public String getEngName() {
		return engName;
	}
	public void setEngName(String engName) {
		this.engName = engName;
	}
	
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getImporFlag() {
		return imporFlag;
	}
	public void setImporFlag(String imporFlag) {
		this.imporFlag = imporFlag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getMissCnt() {
		return missCnt;
	}
	public void setMissCnt(int missCnt) {
		this.missCnt = missCnt;
	}

}
