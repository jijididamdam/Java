package wordGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import word.WordInfo;
import wordManager.WordManager;

public class WordGame {
// 게임하기, 채점하기, 채점 후 처리하기
	// 게임에 필요한 단어목록이 필요하다 > WordManager 객체에 의존
	private WordManager wmanager = null;
	private HashMap<String, WordInfo> wgList = null;
	private String[] wgKeySet = null;   // 제시 단어를 여기 저장...
	private int[] wgKeySetCnt = null;
	private Scanner in = new Scanner(System.in);
	private int jumsu = 0;
	private ArrayList<String> badWordList = new ArrayList<>();

	public WordGame(WordManager w) {
		this.wmanager = w;
	}

	public void WordGameRun() {
		// menu();
		init();
		gameRun();
	}

	private void gameRun() {
		Random r = new Random();
		for (;;) {
			int nowIdx = r.nextInt(wgKeySet.length);
			String nowKey = wgKeySet[nowIdx];  // 랜덤 인덱스의 위치의 제시어
			          // 제시어 위치와 같은 배열의 값을 증가 > 
			WordInfo nowWordInfo = wgList.get(nowKey);
			String nowkorName = nowWordInfo.getKorName();
			System.out.println("제시 단어 : " + nowkorName);
			if(nowWordInfo.getMissCnt() > 1) {
				System.out.println("<오답조심>");
			}
			String inputKey = in.nextLine();
			if (inputKey.equals("exit")) { // 프로그램 종료
				prtPoint();
				badWordprt();
				prtWordMiss();
				break;
			}
			if (inputKey.equals(nowKey)) {
				System.out.println(" 정답 ");
				nowWordInfo.setCheckFlag(true);
				jumsu += 10;
			} else {
				System.out.println(" 오답 ");
				wgKeySetCnt[nowIdx]++;   
				// 틀린단어를 출력하는 것이 .. 내가 입력한 것이냐 - 1 단어만 입력 > ArrayList
				badWordList.add("제시단어 : " + nowKey + "입력한단어 : " + inputKey); // 1번
				nowWordInfo.setCheckFlag(false);
			}
			
		}
	}

	private void prtWordMiss() {
		System.out.println("---- 틀린단어 분석 -------");
		for(int i=0; i < wgKeySetCnt.length; i++) {
			if(wgKeySetCnt[i]!=0) {
				System.out.println("단어 : "+wgKeySet[i]+ " 틀린 횟수 : "+wgKeySetCnt[i]);
			}
		}
		
	}

	private void prtPoint() {
		System.out.println("당신의 점수 : " + jumsu);
	}

	private void badWordprt() {
		System.out.println("---- 너가 틀린 거 ----------");
		for (int i = 0; i < badWordList.size(); i++) {
			System.out.println(badWordList.get(i));
		}

	}

	private void init() { // 게임 준비 메서드
		// TODO Auto-generated method stub
		wgList = wmanager.getwList(); // wordmanger의 단어 정보 가져오기
		wgKeySet = new String[wgList.size()];
		wgKeySetCnt = new int[wgList.size()];
		int wgKeySetFlag = 0;
		for (String nowKey : wgList.keySet()) {
			wgKeySet[wgKeySetFlag] = nowKey;
			wgKeySetFlag++;
		}
		/*
		 * System.out.println("--- 가져온 키값 리스트 ----------"); for (int i = 0; i <
		 * wgKeySet.length; i++) { System.out.println(i + "/" + wgKeySet[i]); }
		 */
	}

	/*
	 * private void menu() { System.out.println("1. 게임하기"); }
	 */
}
