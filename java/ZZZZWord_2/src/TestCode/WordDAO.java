package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/* DAO ���� data access object
 * �����ͺ��̽��� �����Ͽ� ������ ����
 * ���� ���� �� ���ϰ��� �޴� �۾��� �����ϴ� ��ü�� �ǹ������� DAO��� �Ѵ�.
 * �� ��ü�� ����̹��ε�
 * �����û, ��������, ������� �޴´�.
 * �ڿ��� �ݳ��ϴ� �ڵ尡 ���Եȴ�.
 */

public class WordDAO {

	// �����ͺ��̽� ������ ���� �ڿ�(��ü)�� �ּҸ� ������ ���������� ����
	private Connection conn=null;
	public WordDAO(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
		}
	}
	
	// �ʿ��� ������ ���ؼ� ������ �޼��� ����
	public boolean connect() {
		// ���ؼ��� �����ϰ� �� ����� ��� ���� �ڵ�
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch(SQLException e) {
			System.out.println("�������");
			return false;
		}
		
	}
	// insert into word1 values('a','b','c','d',default);
	public void insertWord(WordInfoDTO w) {
		// �����û�� �ϰ� �������� ����� �ް� �����ڿ��� �ݳ��ϴ� ����
		if(connect()) {
			String sql="insert into word1 values(?,?,?,?,default)";
			//���� ������ �����ϴ� ��ü
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); // ���� ��ü ������
				psmt.setString(1, w.getEngName());
				psmt.setString(2, w.getKorName());
				psmt.setString(3, w.getImporFlag());
				psmt.setString(4, w.getComment());
				
				int r = psmt.executeUpdate(); // ���� ���� �� ���ϰ� ����
				System.out.println(r+"���� �ԷµǾ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}
	
	public void delWord(String dword,String tname) {
		if(connect()) {
			//String sql = "delete from "+tname+" where eng=?";
			String sql = "delete from "+"?"+" where eng=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, tname);
				psmt.setString(2, dword); 				
				int r = psmt.executeUpdate();
				System.out.println(r+"���� �����Ǿ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}
	
	public void modWord(String mword, String kword, String cword) {
		if(connect()) {
			String sql = "update word1 set "+cword+"=? where eng=?";
			//String sql = "update word1 set kor=? where eng=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1,kword);
				psmt.setString(2,mword);
				int r = psmt.executeUpdate();
				System.out.println(r+"���� �����Ǿ����ϴ�.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<WordInfoDTO> allSelect() {
		/* �Ϲ������� select����� ������ ���� 
		 * Ʃ���� 1�� �� ��� : DTO ��ü�� ������ 
		 * Ʃ���� �������� ��� : ArrayList or HashMap(**) ���� ������ (�ƹ��ų� ��� ����)
		 */
		ResultSet rs=null;           // ���� ���� ����� ���Ϲ޴� ��ü
		
		if(connect()) {
			String sql="select * from word1";
			//���� ������ �����ϴ� ��ü
			ArrayList<WordInfoDTO> wordList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();    // ���� ��ü ��� ����
				rs = stmt.executeQuery(sql);                // ���� ���� �� ���ϰ� ����
				while(rs.next()) {   // �ִ��� Ȯ���ϴ� �ڵ� 
					/* �������� �ڵ�
					 * rs���������� ù��° Ʃ�ú��� ����Ű�� �ִ�. �� Ʃ�ú��� �����´�.
					 * Ʃ�� ������ ���� DTO�� ����Ѵ�. �׷��� ù��° Ʃ���� �������� ���� ��ü�� �����
					 * �� ��ü�� ���� �����ϱ� ����  setter ����ѰŰ� rs�κ��� �ش� �÷��� �����ͼ� setter�� �Ű������� �����ϰ�
					 * DTO ��ü�� �����Ѵ�..rs���� ���� ������ ���� rs.getString("�÷���");
					 */
					WordInfoDTO tempW= new WordInfoDTO();
					tempW.setEngName(rs.getString("eng"));
					tempW.setKorName(rs.getString("kor"));
					tempW.setImporFlag(rs.getString("info"));
					tempW.setComment(rs.getString("comm"));
					tempW.setMissCnt(rs.getInt("misscnt"));
					wordList.add(tempW);
				}
				conn.close(); // ���������� �ݳ�
				return wordList;
			}  catch(SQLException e) {
				e.printStackTrace();
			}						
		} else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
		return null;
	}
	
	 
}
