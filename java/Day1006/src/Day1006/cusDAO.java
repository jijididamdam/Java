package Day1006;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class cusDAO {
	private Connection conn=null;
	private ArrayList<cusDTO> clist = new ArrayList<>();
	
	public cusDAO() {
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
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
	
	void putcus(cusDTO ct) {
		if(connect()) {
			String sql = "insert into cus values(?,?,?,?,default)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, ct.getId());
				ps.setString(2, ct.getName());
				ps.setString(3, ct.getPass());
				ps.setString(4, ct.getAddr());

				int r = ps.executeUpdate();
				System.out.println("DB�� "+r+"���� �ԷµǾ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
	
	}
	
	public ArrayList<cusDTO> allPrt() {
		ResultSet rs = null;
		
		if(connect( )) {
			String sql = "select * from cus";
			
			try {
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				while(rs.next()) {
					cusDTO ct = new cusDTO();
					ct.setId(rs.getString("id"));
					ct.setName(rs.getString("name"));
					ct.setPass(rs.getString("pass"));
					ct.setAddr(rs.getString("addr"));
					ct.setPoint(rs.getInt("point"));
					clist.add(ct);
				}
				conn.close();
				return clist;
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�������");
		}
		return null;
		
	}
	
	void modcus(String mid, String mm, String cal) {
		if(connect()) {
			String sql = "update cus set "+cal+"=? where id=?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, mm);
				ps.setString(2, mid);
				int r = ps.executeUpdate();
				System.out.println(" �����Ǿ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�������");
		}
	}
	
	void delcus(String did) {
		if(connect()) {
			String sql = "delete from cus where id=?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, did);
				
				int r = ps.executeUpdate();
				System.out.println("�����Ǿ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				
			}
		} else {
			System.out.println("�������");
		}
	}
	
	
	
	
	
}
