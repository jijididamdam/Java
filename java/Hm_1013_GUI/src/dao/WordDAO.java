package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dto.WordDTO;
import sql_exception.SQL_Exception;

public class WordDAO {
	private Connection conn = null;
	public WordDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε强��");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ε����");
		}
	}
	public boolean connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�������");
			e.printStackTrace();
			return false;
		}
	}
	public void insert_Word(WordDTO w) {
	      if(connect()) {
	         String sql="insert into word values (?,?,?,?)";
	         try {
	            PreparedStatement psmt = conn.prepareStatement(sql);
	            psmt.setString(1, w.getEng());
	            psmt.setString(2, w.getKor());
	            psmt.setString(3, w.getImpor());
	            psmt.setString(4, w.getInfo());
	            int r = psmt.executeUpdate();
	            System.out.println(r+"���� �ԷµǾ����ϴ�");
	            conn.close();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            new SQL_Exception();
	         }
	      }else {
	         System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
	      }
	}
	public void delete_word(String w) {
		if(connect()) {
			String sql="delete from  where =?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, w);
				int a = psmt.executeUpdate();
				System.out.println(a+"�� ���� �Ϸ�");
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
	}
	public ArrayList<WordDTO> search(String w) {
		ArrayList<WordDTO> list = new ArrayList<>();
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from word where eng=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, w);
				resultSet = psmt.executeQuery();
				while(resultSet.next()) {
					WordDTO wordDTO = new WordDTO();
					wordDTO.setEng(resultSet.getString("eng"));
					wordDTO.setKor(resultSet.getString("kor"));
					wordDTO.setImpor(resultSet.getString("impor"));
					wordDTO.setInfo(resultSet.getString("info"));
					list.add(wordDTO);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
		return null;
	}
	public ArrayList<WordDTO> allselect(){
		ResultSet resultSet = null;
		if(connect()) {
			String sql="select * from word";
			ArrayList<WordDTO> list = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				resultSet = stmt.executeQuery(sql);
				while(resultSet.next()) {
					WordDTO wordDTO = new WordDTO();
					wordDTO.setEng(resultSet.getString("eng"));
					wordDTO.setKor(resultSet.getString("kor"));
					wordDTO.setImpor(resultSet.getString("impor"));
					wordDTO.setInfo(resultSet.getString("info"));
					list.add(wordDTO);
				}
				conn.close();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("������ �� �� ��� �Է��� ���� ���մϴ�.");
		}
		return null;
	}
	public WordDTO selectOne(String word) {
	      ResultSet rs=null;
	      WordDTO w = null;
	      if(connect()) {
	         try {
	            String sql="select * from word where eng=?";
	            PreparedStatement psmt = conn.prepareStatement(sql);
	            psmt.setString(1, word);
	            rs = psmt.executeQuery();
	            if(rs.next()) {
	               w = new WordDTO();
	               w.setKor(rs.getString("kor"));
	               w.setEng(rs.getString("eng"));
	               w.setImpor(rs.getString("impor"));
	               w.setInfo(rs.getString("info"));
	            }
	            conn.close();
	            
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	      return w;
	   }
}
