package Book;

public class Book {
	int no=0;
	String name=null;
	int year=0;
	String writer=null;
	
	//å ���� �����ϴ� �޼���
	public void setting(int no, String name, int year, String writer) {
		this.no=no;
		this.name=name;
		this.year=year;
		this.writer=writer;
	}
	
	public void prt() {
		System.out.println("å��ȣ : "+ this.no);
		System.out.println("å�̸� : "+ this.name);
		System.out.println("���� : "+ this.year);
		System.out.println("�ۼ��� : "+ this.writer);
	}
	
}
