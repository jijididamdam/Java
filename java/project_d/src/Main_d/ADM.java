package Main_d;

public class ADM {
	private String id = "adm";
	private String pwd = "12345";
	
	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	JFmain jf = new JFmain();
	Login lg = new Login();
	
	void ADMlog(String nid, String npwd) {
		if(nid.equals(id)&&npwd.equals(pwd)) {
			jf.JFmain();
		} else {
			
		}
	}
}
