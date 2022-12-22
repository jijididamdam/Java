package wordManager;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.Scanner;

import TestCode.WordDAO;
import TestCode.WordInfoDTO;
import word.WordInfo;



public class WordManager {
	//�ܾ� ����, ����, ����, ��ü����
	// WordInfo ��ü�� �ʿ��մϴ�..�� ��ü�� �����ϰ� �ִ�.
	// ������ �ݵ�� �ʿ��� ���� �ƴϴ�.. �����Ҷ��� �ʿ��ϴ�..
	private WordInfo winfo = null;
	private WordDAO wdao= new WordDAO();
	private Scanner in = new Scanner(System.in);
	//private HashMap<String,WordInfo> wList = new HashMap<>();
	
	public WordManager(){

		
	}
	
	//public HashMap<String, WordInfo> getwList() {
		//return wList;
	//}

	public void wordManagerRun() {
	//	for(;;) {
		while(true) {
			menu();
			System.out.println("���� >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addWord();
			}else if(selMenu==2) {
				delWord();
			}else if(selMenu==3) {
				modWord();
			}else if(selMenu==4) {
				listWord();
			}else {
				break;
			}
			
		}
	}
	private void listWord() {
		/* ���� Ű����� �Է��� ���� ����.
		 * ���� : select * from word1;
		 * select ������ ��ȸ
		 * listWord()���� ��ȸ�� �����͸� �����;� �Ѵ�.(���ϰ� �޾ƿ´�.)
		 */
		
		ArrayList<WordInfoDTO> wordList = wdao.allSelect();
		for(WordInfoDTO w : wordList) {
			w.prt();
		}
		
		
		
	}

	private void modWord() {
		// ������
		System.out.println("������ ����ܾ �Է��ϼ���");
		String mword=in.nextLine();
		choice();
		int sel=in.nextInt();
		in.nextLine();
		if(sel==1) {
			String cword="kor";
			System.out.println("������ ���� �Է��ϼ���");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		} else if(sel==2) {
			String cword="info";
			System.out.println("������ �߿䵵�� �Է��ϼ���");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		} else if(sel==3) {
			String cword="comm";
			System.out.println("������ ������ �Է��ϼ���");
			String kword=in.nextLine();
			wdao.modWord(mword,kword,cword);
		}
	}

	private void choice() {
		// TODO Auto-generated method stub
		System.out.println("1. �� ����");
		System.out.println("2. �߿䵵 ����");
		System.out.println("3. ���� ����");
	}

	private void delWord() {
		//������ 
		System.out.println("������ ����ܾ �Է��ϼ���");
		String dword = in.nextLine();
		System.out.println("���̺���� �Է����ּ���");
		String tname = in.nextLine();
		wdao.delWord(dword,tname);
	}

	private void addWord() {
		WordInfoDTO ww = new WordInfoDTO();		
		System.out.println("�ܾ��߰� -----");
		System.out.println("key�� ����� ���� �ܾ� �Է��ϼ���");
		String keyWord = in.nextLine();
		ww.setEngName(keyWord);
		System.out.println("Value �� �ѱ� �ܾ��� �ǹ̸� �Է��ϼ���");
		String valueKorWord = in.nextLine();
		ww.setKorName(valueKorWord);
		System.out.println("Value ��  �߿䵵�� �Է��ϼ���");
		String valueimporWord = in.nextLine();
		ww.setImporFlag(valueimporWord);
		System.out.println("Value �� ���� �Է��ϼ���");
		String valuecommetkeyWord = in.nextLine();
		ww.setComment(valuecommetkeyWord);
		wdao.insertWord(ww);
		

		
		
	//	winfo.setComment(valuecommetkeyWord);
	//	winfo.setImporFlag(valueimporWord);
		//winfo.setKorName(valueKorWord);
		
		//wList.put(keyWord, winfo);
		
	}

	private void menu() {
		System.out.println("1. �߰�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. ��ü����");
		System.out.println("5. ����");
	}

}
