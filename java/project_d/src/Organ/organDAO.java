package Organ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;


public class organDAO {
	private Connection conn = null;
	private ArrayList<organDTO> olist = null;
	private ResultSet rs = null;
	
	public organDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("2");
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
	
	
	

	public void insertO(organDTO odto) {
		// TODO Auto-generated method stub
		if(connect()) {
			try {
				String sql = "insert into organ values(onos.NexTVAL,?,?,?,?)";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,odto.getOname());
				ps.setString(2, odto.getOtel());
				ps.setInt(3, odto.getPid());
				ps.setInt(4, odto.getGid());
				
				int r = ps.executeUpdate();
				System.out.println("DB에" + r + "건이 입력되었습니다.");
				conn.close();

			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결에 실패하였습니다.");
		}
	}
	
	public void delO(JTextField textOno) {
		int nid = Integer.parseUnsignedInt(textOno.getText());
		if(connect()) {
			try {
				String sql = "delete from organ where ono="+nid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();
			} catch(SQLException e) {
				
			}
		} else {
			System.out.println("연결실패");
		}		
	}
	
	public ArrayList<organDTO> allO(){
		olist = new ArrayList<>();
		if(connect()) {
			try {
				String sql = "select * from organ";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					organDTO odto = new organDTO();
					odto.setOno(rs.getInt("ono"));
					odto.setOname(rs.getString("oname"));
					odto.setOtel(rs.getString("otel"));
					odto.setPid(rs.getInt("pid"));
					odto.setGid(rs.getInt("gid"));
					olist.add(odto);
				}
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		return olist;
	}

	
	public organDTO selectOneO(String sid) {
		organDTO odto = null;
		int nono = Integer.parseInt(sid);
		if(connect()) {
			try {
				String sql = "select * from organ where ono=?";				
				PreparedStatement ps = conn.prepareStatement(sql);
			    ps.setInt(1,nono);
			    rs = ps.executeQuery();
				//System.out.println("DB에" + r + "건을 찾았습니다.");
				
				while(rs.next()) {
					System.out.println("aaa");
					odto = new organDTO();
					odto.setOno(rs.getInt("ono"));
					odto.setOname(rs.getString("oname"));
					odto.setOtel(rs.getString("otel"));
					odto.setPid(rs.getInt("pid"));
					odto.setGid(rs.getInt("gid"));
				}
				conn.close();
				return odto;
			} catch(SQLException e) {
				
			}
		}
		return odto;
	}

	public ArrayList<organDTO> schO(String sname) {
		olist = new ArrayList<>();
		if(connect()) {
			try {
				String sql = "select * from organ where oname like '%"+sname+"%'";
				Statement st = conn.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					organDTO odto = new organDTO();
					odto = new organDTO();
					odto.setOno(rs.getInt("ono"));
					odto.setOname(rs.getString("oname"));
					odto.setOtel(rs.getString("otel"));
					odto.setPid(rs.getInt("pid"));
					odto.setGid(rs.getInt("gid"));
					olist.add(odto);
				}
				conn.close();
			} catch(SQLException e) {
				
			}
		}
		
		return olist;
	}
	public void modO(organDTO odto) {
		if(connect()) {
			try {
				String sql = "update organ set oname=?,otel=?,pid=?gid=? where ono=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,odto.getOname());
				ps.setString(2, odto.getOtel());
				ps.setInt(3, odto.getPid());
				ps.setInt(4, odto.getGid());
				ps.setInt(5, odto.getOno());
				
				int r = ps.executeUpdate();
				System.out.println("DB에" + r + "건이 입력되었습니다.");
				conn.close();				
				
			} catch(SQLException e) {
				
			}
		}
	}
	
	
	
	
	

}
