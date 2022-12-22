package EX1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WordDAO {
   //데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수 선언
   private Connection conn = null;
   private ResultSet rs = null;
   private ArrayList<WordDTO> wlist = null;
   
   public WordDAO(){   // 생성자
      //예외.. 프로그램 실행 중에 발생하는 것.. 에러: 실행조차 안됨..
      try {
         // 1. 드라이버 로딩(필요한 클래스를 자바로 로드)
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("로드 성공");
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         //e.printStackTrace();
         System.out.println("로드 실패");
      }
   }
   //필요할때마다 커넥션 얻어는 메서드 정의
   public boolean connect() { // 
      try {
         // 커넥션을 시도하고 그 결과를 얻어 오는 코드... 
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
         System.out.println("연결성공");
         return true;
      } catch (SQLException e) {
         System.out.println("연결실패");
         return false;
      }
   }
   
   
   public void insert(WordDTO w) {
	   if(connect()) {
		   try {
		   String sql = "insert into newword values (?,?,?,?)";
		   PreparedStatement psmt = conn.prepareStatement(sql);
		   psmt.setString(1, w.getEng());
		   psmt.setString(2, w.getKor());
		   psmt.setString(3, w.getImpor());
		   psmt.setString(4, w.getInfo());
		  int r = psmt.executeUpdate();
		  System.out.println(r+"건 입력완료");
		  conn.close();
		   
		   
		   } catch(SQLException e) {
			   e.printStackTrace();
		   }
	   }
   }
   
   public ArrayList<WordDTO> selectAll() {
	   wlist = new ArrayList<>();
	   if(connect()) {
		   String sql = "select * from newword";
		   try {			   
			   Statement st = conn.createStatement();
			   rs = st.executeQuery(sql);
			   while(rs.next()) {
				   WordDTO wdto = new WordDTO();
				   wdto.setEng(rs.getString("eng"));
				   wdto.setKor(rs.getString("kor"));
				   wdto.setImpor(rs.getString("impor"));
				   wdto.setInfo(rs.getString("info"));
				   wlist.add(wdto);
			   }
			   conn.close();
			   return wlist;
			   
		   } catch(SQLException e) {
			   
		   }
	   }
	   return null;
   }
   
   /*
   public ArrayList<WordDTO> selectAll() {
	      ResultSet r = null;
	      ArrayList<WordDTO> wlist = new ArrayList<>();
	      if (connect()) {
	         String s = "select * from newword";
	         try {
	            Statement st = conn.createStatement();
	            r = st.executeQuery(s);
	            while (r.next()) {
	               WordDTO w = new WordDTO();
	               w.setEng(r.getString("eng"));
	               w.setKor(r.getString("kor"));
	               w.setImpor(r.getString("impor"));
	               w.setInfo(r.getString("info"));
	               wlist.add(w);
	            }
	            
	            conn.close();
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      }
	      return wlist;
	   }
	   */

   
   
   public WordDTO selectOne(String word) {
	      WordDTO w = null;
	      if(connect()) {
	         try {
	            String sql="select * from newword where eng=?";
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
