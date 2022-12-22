package main;

import java.util.Scanner;

import wordGame.WordGame;
import wordManager.WordManager;

public class MainMenu {
	// 1. ��������
	   // ������ �����ϱ� ���ؼ� �ʿ��� ����.. WordGame, WordManager
	private WordManager wmge=new WordManager();
	private WordGame wgame= new WordGame(wmge);
	private Scanner in = new Scanner(System.in);
	
	MainMenu(){
		// 1. �ܾ����, 2. �ܾ������ �б� �ϴ� Ŭ����
		for(;;) {
			System.out.println("1.  �ܾ����");
			System.out.println("2.  �ܾ����");
			System.out.println("3.  ���α׷�����");
			System.out.println("���� >>");
			int selMenu = in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				wmge.wordManagerRun();
			}else if(selMenu==2) {
				wgame.WordGameRun();
			}else {
				break;
			}
		}
		
	}
	
}
