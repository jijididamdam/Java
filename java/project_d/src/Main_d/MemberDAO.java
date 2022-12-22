package Main_d;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

public class MemberDAO {
	
	private Connection conn = null;
	private ArrayList<MemberDTO> mlist = null;
	
	private ResultSet rs = null;
	
	MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("�ε强��");
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
		}
	}
	
	public boolean connect() { 
		try {			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch (SQLException e) {
			System.out.println("�������");
			return false;
		}
	}
	
	public void insertM(MemberDTO mdto) {
		if(connect()) {
			try {
				String sql = "insert into Mem values(?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, mdto.getId());
				ps.setString(2, mdto.getPwd());				
				int r = ps.executeUpdate();
				System.out.println("DB��" + r + "���� �ԷµǾ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				
			}
		} else {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
	}
	
	public void delM(JTextField textId) {
		String nid = textId.getText();
		if(connect()) {
			try {
				String sql = "delete from Mem where id="+nid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();						
			}catch(SQLException e) {
				
			}
		} 
	}
	
	public ArrayList<MemberDTO> allM() {
		mlist = new ArrayList<>();
		if(connect()) {
			try {
				String sql = "select * from Mem";
				Statement st = conn.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					MemberDTO mdto = new MemberDTO();
					mdto.setId(rs.getString("id"));
					mdto.setPwd(rs.getString("pwd"));
					mlist.add(mdto);
				}
				conn.close();
				return mlist;
			} catch(SQLException e) {
				
			}
		}
		return null;
	}

	public void modM(String mid, String mpwd) {
		if(connect()) {
			try {
				String sql = "update mem set pwd="+mpwd+" where id="+mid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();				
			} catch(SQLException e) {
				
			}
		}
		
	}
	
	
	
	
	

}
