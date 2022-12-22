package Day1006;

public class cusDTO {
	
	String id = null;
	String name = null;
	String pass = null;
	String addr = null;
	int point =0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void prt() {
		System.out.println("아이디 : "+id);
		System.out.println("이름 : "+name);
		System.out.println("비밀번호 : "+pass);
		System.out.println("주소 : "+addr);
		System.out.println("포인트 : "+point);
		System.out.println("---------------");
	}

}
