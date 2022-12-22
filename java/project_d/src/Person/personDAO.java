package Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class personDAO {
	private Connection conn = null;
	private ArrayList<personDTO> plist = null;

	// private JComboBox<personDTO> slist = null;
	private ResultSet rs = null;

	public personDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//System.out.println("1");
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

	public void insertP(personDTO pdto) {
		if (connect()) {
			// System.out.println("okok");

			try {
				String sq = "insert into pers values(?,?,to_date('" + pdto.getPdtM() + "-" + pdto.getPdtD() + "-"
						+ pdto.getPdtY() + " " + pdto.getPdtH() + "','mm-dd-yyyy hh24'),?,?,?,?,?)";

				PreparedStatement ps = conn.prepareStatement(sq);
				// System.out.println("????");
				ps.setInt(1, pdto.getPid());
				ps.setString(2, pdto.getPname());
				ps.setString(3, pdto.getPaddr());
				ps.setString(4, pdto.getPpc());
				ps.setString(5, pdto.getPclo());
				ps.setString(6, pdto.getPrsn());
				ps.setString(7, pdto.getPhoto());

				int r= ps.executeUpdate();
				System.out.println("DB에" + 1 + "건이 입력되었습니다.");
				conn.close();

			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결에 실패하였습니다.");
		}
	}

	public void delP(JTextField textPid) {
		int nid = Integer.parseUnsignedInt(textPid.getText());
		if (connect()) {
			try {
				String sql = "delete from pers where pid=" + nid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				conn.close();
			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결실패");
		}
	}

	public ArrayList<personDTO> allP() {
		plist = new ArrayList<>();
		if (connect()) {
			try {
				String sql = "select * from pers";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);

				while (rs.next()) {
					personDTO pdto = new personDTO();
					pdto.setPid(rs.getInt("pid"));
					pdto.setPname(rs.getString("pname"));
					pdto.setPdt(rs.getString("pdt"));
					// pdto.setPdt(rs.getString("TO_CHAR(INDATE,'MM-DD-YYYYHH24:MI')"));
					pdto.setPaddr(rs.getString("paddr"));
					pdto.setPpc(rs.getString("ppc"));
					pdto.setPclo(rs.getString("pclo"));
					pdto.setPrsn(rs.getString("prsn"));
					pdto.setPhoto(rs.getString("photo"));
					plist.add(pdto);
				}
				conn.close();
				return plist;
			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결에 실패했습니다.");
		}
		return plist;
	}

	public personDTO selectOneP(String sid) {
		personDTO pdto = null;
		int nid = Integer.parseInt(sid);
		if (connect()) {
			try {
				String sql = "select * from pers where pid=" + nid;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					pdto = new personDTO();
					pdto.setPid(rs.getInt("pid"));
					pdto.setPname(rs.getString("pname"));
					pdto.setPdt(rs.getString("pdt"));
					// pdto.setPdt(rs.getString("TO_CHAR(INDATE,'MM-DD-YYYYHH24:MI')"));
					pdto.setPaddr(rs.getString("paddr"));
					pdto.setPpc(rs.getString("ppc"));
					pdto.setPclo(rs.getString("pclo"));
					pdto.setPrsn(rs.getString("prsn"));
					pdto.setPhoto(rs.getString("photo"));
					// slist.addItem(pdto);
				}
				conn.close();

			} catch (SQLException e) {

			}
		}
		return pdto;
	}

	public ArrayList<personDTO> schP(String sname) {
		plist = new ArrayList<>();
		if (connect()) {
			try {
				String sql = "select * from pers where pname like '%"+sname+"%'";
				//String sql = "select * from pers where pname=" + sname;
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);

				while (rs.next()) {
					personDTO pdto = new personDTO();
					pdto.setPid(rs.getInt("pid"));
					pdto.setPname(rs.getString("pname"));
					pdto.setPdt(rs.getString("pdt"));
					pdto.setPaddr(rs.getString("paddr"));
					pdto.setPpc(rs.getString("ppc"));
					pdto.setPclo(rs.getString("pclo"));
					pdto.setPrsn(rs.getString("prsn"));
					plist.add(pdto);
				}
				conn.close();
				return plist;
			} catch (SQLException e) {

			}
		} else {
			System.out.println("연결에 실패했습니다.");
		}
		return null;
	}

	public ArrayList<personDTO> selectTwoP(String sname) {
		ArrayList<personDTO> pplist = new ArrayList<>();

		if (connect()) {
			try {
				String sql = "select * from pers where pname like '%"+sname+"%'";
				Statement st = conn.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
					personDTO pdto = new personDTO();
					pdto.setPid(rs.getInt("pid"));
					pdto.setPname(rs.getString("pname"));
					pdto.setPdt(rs.getString("pdt"));
					// pdto.setPdt(rs.getString("TO_CHAR(INDATE,'MM-DD-YYYYHH24:MI')"));
					pdto.setPaddr(rs.getString("paddr"));
					pdto.setPpc(rs.getString("ppc"));
					pdto.setPclo(rs.getString("pclo"));
					pdto.setPrsn(rs.getString("prsn"));

					pplist.add(pdto);
				}
				conn.close();

			} catch (SQLException e) {

			}
		}
		return pplist;
	}

	public void modP(personDTO pdto) {
		if (connect()) {
			try {
				// String sql = "update pers set "+cal+"="+mval+" where pid="+mid;
				String sql = "update pers set pname=?,pdt=TO_DATE('" + pdto.getPdtM() + "/" + pdto.getPdtD() + "/"
						+ pdto.getPdtY() + " " + pdto.getPdtH()
						+ "','mm/dd/yyyy hh24'),paddr=?,ppc=?,pclo=?,prsn=? where pid=?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, pdto.getPname());
				ps.setString(2, pdto.getPaddr());
				ps.setString(3, pdto.getPpc());
				ps.setString(4, pdto.getPclo());
				ps.setString(5, pdto.getPrsn());
				ps.setInt(6, pdto.getPid());
				int r = ps.executeUpdate();
				System.out.println("DB에" + r + "건이 입력되었습니다.");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
