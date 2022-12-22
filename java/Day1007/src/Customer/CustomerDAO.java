package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {

	private Connection conn = null;
	private ResultSet rs = null;

	public CustomerDAO() {
		try {
			Class.forName("oracl.jdbc.driver.OracleDriver");
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
	
	void modc(String mid, String mval, String cal) {
		if(connect()) {
			String sql = "update ctm set "+cal+"="+mval+" where cid="+mid;
			
			try {
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();
			} catch(SQLException e) {
				
			}
		}
	}

	public void delc(String did) {
		if (connect()) {
			String sql = "delete from ctm where cid="+did;

			try {
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();

			} catch (SQLException e) {

			}
		}

	}

	void putc(Customer ct) {
		if (connect()) {
			String sql = "insert into ctm values(?,?,?)";

			try {
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, ct.getCid());
				ps.setString(2, ct.getCname());
				ps.setString(3, ct.getCpw());

				ps.executeUpdate();
				conn.close();
			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<Customer> allCus() {
		if (connect()) {
			String sql = "select * from ctm";
			// select * from 고객 where id like '%?%';

			ArrayList<Customer> clist = new ArrayList<>();

			try {
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Customer cus = new Customer();
					cus.setCid(rs.getString("cid"));
					cus.setCname(rs.getString("cname"));
					cus.setCpw(rs.getString("cpw"));
					clist.add(cus);

					return clist;

				}
			} catch (SQLException e) {

			}
		}
		return null;
	}

}
