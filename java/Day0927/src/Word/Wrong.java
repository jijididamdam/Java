package Word;

public class Wrong {
	private int xx=0;
	private String aa=null;
	
	int getX() {
		return xx;
	}
	
	String getA() {
		return aa;
	}
	
	void input(int xx, String aa) {
		this.xx=xx;
		this.aa=aa;
	}
	
	void prt() {
		System.out.println("틀린 횟수 : "+xx+"번");
		System.out.println("오답 : "+aa);
	}
	
	
	
}
