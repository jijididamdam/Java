package Book;

public class Book {
	int no=0;
	String name=null;
	int year=0;
	String writer=null;
	
	//책 정보 저장하는 메서드
	public void setting(int no, String name, int year, String writer) {
		this.no=no;
		this.name=name;
		this.year=year;
		this.writer=writer;
	}
	
	public void prt() {
		System.out.println("책번호 : "+ this.no);
		System.out.println("책이름 : "+ this.name);
		System.out.println("연도 : "+ this.year);
		System.out.println("작성자 : "+ this.writer);
	}
	
}
