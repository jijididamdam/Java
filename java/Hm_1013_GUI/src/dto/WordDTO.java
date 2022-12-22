package dto;

public class WordDTO {
	private String eng = null;
	private String kor = null;
	private String impor = null;
	private String info = null;
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getImpor() {
		return impor;
	}
	public void setImpor(String impor) {
		this.impor = impor;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	public void prt() {
		System.out.println("단어 : "+eng);
		System.out.println("한글 : "+kor);
		System.out.println("중요도 : "+impor);
		System.out.println("설명 : "+info);
	}
}
