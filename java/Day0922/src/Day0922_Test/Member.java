package Day0922_Test;

public class Member {
	String cname=null;
	String id=null;
	String pw=null;
	int point=0;
	
	
	public void setting(String cname, String id, String pw,int point) {
		this.cname=cname;
		this.id=id;
		this.pw=pw;
		this.point=point;
	}
	
	public void prt() {
		System.out.println("고객의 이름 : "+cname);
		System.out.println("고객의 아이디 : "+id);
		System.out.println("비밀번호 : "+pw);
		System.out.println("고객의 포인트 : "+point);
	}
	

}
