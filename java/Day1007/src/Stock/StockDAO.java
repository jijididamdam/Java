package Stock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StockDAO {
	private Connection conn = null;
	private ResultSet rs = null;

	public StockDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드성공");
		} catch (ClassNotFoundException e) {
			System.out.println("로드실패");
		}
	}

	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch (SQLException e) {
			System.out.println("연결실패");
			return false;
		}

	}
	
	public void dels(String did) {
		if(connect()) {
			String sql = "delete from stock where sid="+did;
			
			try {
				Statement st = conn.createStatement();
				rs=st.executeQuery(sql);
				conn.close();
			} catch(SQLException e) {
				
			}
		} else {
			System.out.println("연결실패");
		}
	}
	
	
	void mods(String mid, String mval, String cal) {
		if(connect()) {
			String sql = "update stock set "+cal+"="+mval+" where sid=?";
			
			try {
				PreparedStatement ps = conn.prepareStatement(sql);				
				ps.setString(1,mid);				
				ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				
			}
		} else {
			System.out.println("연결실패");
		}
	}

	void putS(Stock sa) {
		if (connect()) {
			String sql = "insert into stock values(?,?,?,?,?,default)";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, sa.getSid());
				ps.setString(2, sa.getSname());
				ps.setInt(3, sa.getScnt());
				ps.setInt(4, sa.getSprice());
				ps.setString(5, sa.getPname());

				int r = ps.executeUpdate();
				conn.close();

			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<Stock> all() {
		//ResultSet rs = null;

		if (connect()) {
			String sql = "select * from stock";

			ArrayList<Stock> slist = new ArrayList<>();

			try {
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Stock ck = new Stock();
					ck.setSid(rs.getString("sid"));
					ck.setSname(rs.getString("sname"));
					ck.setScnt(rs.getInt("scnt"));
					ck.setSprice(rs.getInt("sprice"));
					ck.setPname(rs.getString("pname"));
					ck.setDate(rs.getString("dt"));

					slist.add(ck);
				}
				conn.close();
				return slist;
			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결실패");
		}
		return null;
	}



}
