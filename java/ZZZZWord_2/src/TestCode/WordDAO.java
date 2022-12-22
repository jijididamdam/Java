package TestCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/* DAO 용어는 data access object
 * 데이터베이스에 접속하여 쿼리를 실행
 * 쿼리 실행 후 리턴값을 받는 작업을 수행하는 객체를 의미적으로 DAO라고 한다.
 * 이 객체는 드라이버로딩
 * 연결요청, 쿼리전송, 결과값을 받는다.
 * 자원을 반납하는 코드가 포함된다.
 */

public class WordDAO {

	// 데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수를 선언
	private Connection conn=null;
	public WordDAO(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로드 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("로드 실패");
		}
	}
	
	// 필요할 때마다 컨넥션 얻어오는 메서드 정의
	public boolean connect() {
		// 컨넥션을 성공하고 그 결과를 얻어 오는 코드
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("연결성공");
			return true;
		} catch(SQLException e) {
			System.out.println("연결실패");
			return false;
		}
		
	}
	// insert into word1 values('a','b','c','d',default);
	public void insertWord(WordInfoDTO w) {
		// 연결요청을 하고 쿼리전송 결과를 받고 연결자원을 반납하는 순서
		if(connect()) {
			String sql="insert into word1 values(?,?,?,?,default)";
			//실제 쿼리를 전달하는 객체
			try {
				PreparedStatement psmt = conn.prepareStatement(sql); // 쿼리 객체 얻어오기
				psmt.setString(1, w.getEngName());
				psmt.setString(2, w.getKorName());
				psmt.setString(3, w.getImporFlag());
				psmt.setString(4, w.getComment());
				
				int r = psmt.executeUpdate(); // 쿼리 실행 후 리턴값 저장
				System.out.println(r+"건이 입력되었습니다.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
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
				System.out.println(r+"건이 삭제되었습니다.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
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
				System.out.println(r+"건이 수정되었습니다.");
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<WordInfoDTO> allSelect() {
		/* 일반적으로 select결과를 가져올 때는 
		 * 튜플이 1개 일 경우 : DTO 객체를 가져옴 
		 * 튜플이 여러개일 경우 : ArrayList or HashMap(**) 으로 가져옴 (아무거나 상관 없음)
		 */
		ResultSet rs=null;           // 쿼리 실행 결과를 리턴받는 객체
		
		if(connect()) {
			String sql="select * from word1";
			//실제 쿼리를 전달하는 객체
			ArrayList<WordInfoDTO> wordList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();    // 쿼리 객체 얻어 오기
				rs = stmt.executeQuery(sql);                // 쿼리 실행 후 리턴값 저장
				while(rs.next()) {   // 있는지 확인하는 코드 
					/* 가져오는 코드
					 * rs참조변수는 첫번째 튜플부터 가리키고 있다. 그 튜플부터 가져온다.
					 * 튜플 가져올 때는 DTO를 사용한다. 그래서 첫번째 튜플을 가져오기 위해 객체를 만들고
					 * 그 객체에 값을 저장하기 위해  setter 사용한거고 rs로부터 해당 컬럼을 가져와서 setter의 매개변수로 전달하고
					 * DTO 객체에 저장한다..rs에서 값을 가져올 때는 rs.getString("컬럼명");
					 */
					WordInfoDTO tempW= new WordInfoDTO();
					tempW.setEngName(rs.getString("eng"));
					tempW.setKorName(rs.getString("kor"));
					tempW.setImporFlag(rs.getString("info"));
					tempW.setComment(rs.getString("comm"));
					tempW.setMissCnt(rs.getInt("misscnt"));
					wordList.add(tempW);
				}
				conn.close(); // 연결차원을 반납
				return wordList;
			}  catch(SQLException e) {
				e.printStackTrace();
			}						
		} else {
			System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
		}
		return null;
	}
	
	 
}
