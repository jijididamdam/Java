package Shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingDAO {
	
	Connection conn = null;
	ResultSet rs = null;
	
	ShoppingDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε强��");
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
		}
	}
	
	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch(SQLException e) {
			System.out.println("�������");
			return false;
		}
	}
	
	void putsh(String lid, String fsid, int fccnt, int sprice, String sdt) {
		if(connect()) {
			String sql = "insert into ord values(?,?,?,?,?)";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, lid);
				ps.setString(2, fsid);
				ps.setInt(3,fccnt);
				ps.setInt(4, sprice);
				ps.setString(5, sdt);
				
				ps.executeUpdate();
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	

}
