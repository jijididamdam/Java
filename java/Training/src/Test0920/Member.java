package Test0920;

public class Member {
	String name=null;
	int age=1;
	
	Member(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void prt() {
		System.out.println(name+"/"+age);
	}

}
