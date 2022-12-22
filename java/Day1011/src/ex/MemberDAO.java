package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MemberDAO {
   //데이터베이스 연결을 위한 자원(객체)의 주소를 저장할 참조변수 선언
   private Connection conn = null;
   public MemberDAO(){   // 생성자
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
   // insert into word1 values ('a','b','c','d',default);
   public void insertWord(MemberDTO w) {
      //2. 연결요청을 하고 쿼리전송 결과를 받고 연결자원을 반납하는 순서 
      if(connect()) {
         String sql="insert into nnn values (?,?,?,?)";
         //실제 쿼리를 전달하는 객체
         try {
            PreparedStatement psmt = conn.prepareStatement(sql); //쿼리 객체 얻어 오기
            psmt.setString(1, w.getId());  //mapping
            psmt.setString(2, w.getName());  //mapping
            psmt.setString(3, w.getPass());  //mapping
            psmt.setString(4, w.getTel());  //mapping
            int r = psmt.executeUpdate();   // 쿼리 실행 후 리턴값 저장.
            System.out.println(r+"건이 입력되었습니다");
            conn.close();  // 연결자원을 반납
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }else {
         System.out.println("연결을 할 수 없어서 입력을 하지 못합니다.");
      }
   }
}

