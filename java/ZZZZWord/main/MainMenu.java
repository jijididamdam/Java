package main;

import java.util.Scanner;

import wordGame.WordGame;
import wordManager.WordManager;

public class MainMenu {
	// 1. 전역구성
	   // 목적을 수행하기 위해서 필요한 변수.. WordGame, WordManager
	private WordManager wmge=new WordManager();
	private WordGame wgame= new WordGame(wmge);
	private Scanner in = new Scanner(System.in);
	
	MainMenu(){
		// 1. 단어관리, 2. 단어게임을 분기 하는 클래스
		for(;;) {
			System.out.println("1.  단어관리");
			System.out.println("2.  단어게임");
			System.out.println("3.  프로그램종료");
			System.out.println("선택 >>");
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
