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
		System.out.println("���� �̸� : "+cname);
		System.out.println("���� ���̵� : "+id);
		System.out.println("��й�ȣ : "+pw);
		System.out.println("���� ����Ʈ : "+point);
	}
	

}
