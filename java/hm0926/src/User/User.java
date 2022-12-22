package User;

public class User {
	private String name=null;
	private Integer age=null;
	
	public User() {
		
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(Integer age) {
		this.age=age;
	}
	
	public void prt() {
		System.out.println("이름 : "+ name);
		System.out.println("나이 : "+age);
	}
	
	public void upAge() {
		age+=1;
	}
	
	

}
