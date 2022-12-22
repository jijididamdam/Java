package Main_d;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MemberDTO {
	private String id = null;
	private String pwd = null;
	MemberDAO mdao = new MemberDAO();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
