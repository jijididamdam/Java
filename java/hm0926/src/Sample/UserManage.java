package Sample;

import User.User;

public class UserManage {
	User us = new User();
	
	public void set() {
		us.setName("ö��");
		us.setAge(5);
		us.prt();
		System.out.println("--------------");
		us.upAge();
		us.prt();
		
	}
		

	
	
	

}
