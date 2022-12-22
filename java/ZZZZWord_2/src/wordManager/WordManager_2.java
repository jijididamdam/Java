package wordManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import word.WordInfo;

public class WordManager_2 {

	// �ܾ� ����, ����, ����, ��ü����
	// WordInfo ��ü�� �ʿ��մϴ�..�� ��ü�� �����ϰ� �ִ�.
	// ������ �ݵ�� �ʿ��� ���� �ƴϴ�.. �����Ҷ��� �ʿ��ϴ�..
	private WordInfo winfo = null;
	private Scanner in = new Scanner(System.in);
	// private HashMap<String,WordInfo> wList = new HashMap<>();

	// public HashMap<String, WordInfo> getwList() {
//	      return wList;
	// }

	private Connection conn = null;

	public WordManager_2() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("�ε� ����");
		}
	}

	public void wordManagerRun() {
		// for(;;) {
		while (true) {
			menu();
			System.out.println("���� >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				addWord();
			} else if (selMenu == 2) {
				delWord();
			} else if (selMenu == 3) {
				modWord();
			} else if (selMenu == 4) {
				listWord();
			} else {
				break;
			}

		}
	}

	private void listWord() {
//	      System.out.println("-- ��ϵ� �ܾ� ��� -- ("+wList.size()+")");
//	      for(String keyinfo : wList.keySet()) {
//	         System.out.println("<�ܾ�����> "+keyinfo);
//	         WordInfo temp = wList.get(keyinfo);
//	         temp.prt();
//	         System.out.println("----------------------");
//	      }
	}

	private void modWord() {
		// ������
	}

	private void delWord() {
		// ������
	}

	public boolean connect() {
		try {
			// Ŀ�ؼ��� �õ��ϰ� �� ����� ��� ���� �ڵ�...
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			System.out.println("���Ἲ��");
			return true;
		} catch (SQLException e) {
			System.out.println("�������");
			return false;
		}
	}

	private void addWord() {
//	      ���� ������ �����Ͽ� �ܾ ������ ���̽��� �����ϵ��� �ڵ�
		if (connect()) {
			WordInfo w = new WordInfo();
			System.out.println("���ܾ �Է��ϼ���");
			String engName = in.nextLine();
			w.setEngName(engName);
			System.out.println("���� �Է��ϼ���");
			String korName = in.nextLine();
			w.setKorName(korName);
			System.out.println("�ڸ�Ʈ�� �Է��ϼ���");
			String comment = in.nextLine();
			w.setComment(comment);
			System.out.println("�߿䵵�� �Է��ϼ���");
			String impo = in.nextLine();
			w.setImporFlag(impo);
			//w.prt();
			String sql = "insert into word1 values(?,?,?,?,default)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);

				psmt.setString(1, w.getEngName());
				//System.out.println(w.getEngName());
				psmt.setString(2, w.getKorName());
				psmt.setString(3, w.getComment());
				psmt.setString(4, w.getImporFlag());
				// System.out.println(psmt);
				int r = psmt.executeUpdate();
				conn.close();
				System.out.println("�Է¿Ϸ�");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void menu() {
		System.out.println("1. �߰�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ��ü����");
		System.out.println("5. ����");
	}

//	      winfo = new WordInfo();      
//	      System.out.println("�ܾ��߰� -----");
//	      System.out.println("key�� ����� ���� �ܾ� �Է��ϼ���");
//	      String keyWord = in.nextLine();
//	      System.out.println("Value �� �ѱ� �ܾ��� �ǹ̸� �Է��ϼ���");
//	      String valueKorWord = in.nextLine();
//	      System.out.println("Value ��  �߿䵵�� �Է��ϼ���");
//	      String valueimporWord = in.nextLine();
//	      System.out.println("Value �� ���� �Է��ϼ���");
//	      String valuecommetkeyWord = in.nextLine();
//	      winfo.setComment(valuecommetkeyWord);
//	      winfo.setImporFlag(valueimporWord);
//	      winfo.setKorName(valueKorWord);
//	      wList.put(keyWord, winfo);
}
