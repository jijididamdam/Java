package Guard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;

import Person.personDTO;

public class guardDAO {
	private Connection conn = null;
	private ArrayList<guardDTO> glist = null;
	private ResultSet rs = null;

	public guardDAO() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("3");
		} catch (ClassNotFoundException e) {
			System.out.println("로드 실패");
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

	public void insertG(guardDTO gdto) {
		if (connect()) {
			try {
				String sql = "insert into guard values(?,?,?,?,?,default,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println("???");
				ps.setInt(1, gdto.getGid());
				ps.setString(2, gdto.getGname());
				ps.setInt(3, gdto.getPid());
				ps.setString(4, gdto.getGrel());
				ps.setString(5, gdto.getGaddr());
				ps.setString(6, gdto.getGtel());

				int r = ps.executeUpdate();
				System.out.println("DB에" + r + "건이 입력되었습니다.");
				conn.close();

			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결에 실패하였습니다.");
		}
	}
	
	
	public void delG(JTextField textGid) {
		int did = Integer.parseUnsignedInt(textGid.getText());
		if(connect()) {
			try {
				String sql = "delete from guard where gid="+did;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();
			} catch(SQLException e) {
				
			}
		} else {
			System.out.println("연결실패");
		}		
	}
	
	public ArrayList<guardDTO> allG() {
		glist = new ArrayList<>();
		if(connect()) {
			try {
				String sql = "select * from guard";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					guardDTO gdto = new guardDTO();
					gdto.setGid(rs.getInt("gid"));
					gdto.setGname(rs.getString("gname"));
					gdto.setPid(rs.getInt("pid"));
					gdto.setGrel(rs.getString("GREL"));	
					gdto.setGaddr(rs.getString("gaddr"));
					gdto.setGdt(rs.getString("gdt"));
					//gdto.setGdt(rs.getString("TO_CHAR(INDATE,'MM-DD-YYYYHH24:MI')"));
					gdto.setGtel(rs.getString("gtel"));
					glist.add(gdto);
				}				
				conn.close();
				
				return glist;
			}catch(SQLException e) {
				
			}
		} else {
			System.out.println("연결에 실패했습니다.");
		}
		return glist;
	}
	
	
	public guardDTO selectOneG(String sid) {
		guardDTO gdto = null;
		int nid = Integer.parseInt(sid);
		if(connect()) {
			try {
				String sql = "select * from guard where gid="+nid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				if(rs.next()) {
					gdto = new guardDTO();
					gdto.setGid(rs.getInt("gid"));
					gdto.setGname(rs.getString("gname"));
					gdto.setPid(rs.getInt("pid"));
					gdto.setGrel(rs.getString("grel"));
					gdto.setGaddr(rs.getString("gaddr"));
					gdto.setGdt(rs.getString("gdt"));
					//gdto.setGdt(rs.getString("TO_CHAR(INDATE,'MM-DD-YYYYHH24:MI')"));
					gdto.setGtel(rs.getString("gtel"));
				}
				conn.close();
				
			}catch(SQLException e) {
				
			}
		}
		return gdto;
	}
	
	public ArrayList<guardDTO> schG(String sname) {
		glist = new ArrayList<>();
		if(connect()) {
			try {
				String sql = "select * from guard where gname like '%"+sname+"%'";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				if(rs.next()) {
					guardDTO gdto = new guardDTO();
					gdto.setGid(rs.getInt("gid"));
					gdto.setGname(rs.getString("gname"));
					gdto.setPid(rs.getInt("pid"));
					gdto.setGrel(rs.getString("GREL"));	
					gdto.setGaddr(rs.getString("gaddr"));
					gdto.setGdt(rs.getString("gdt"));
					gdto.setGtel(rs.getString("gtel"));
					glist.add(gdto);
				}
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		return glist;
	}
	
	public void modG(guardDTO gdto) {
		if(connect()) {
			String sql = "update guard set gname=?,grel=?,pid=?,gaddr=?,gtel=? where gid=?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, gdto.getGname());
				ps.setString(2, gdto.getGrel());
				ps.setInt(3, gdto.getPid());
				ps.setString(4, gdto.getGaddr());
				ps.setString(5, gdto.getGtel());
				ps.setInt(6, gdto.getGid());

				int r = ps.executeUpdate();
				System.out.println("DB에" + r + "건이 입력되었습니다.");
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	

}
