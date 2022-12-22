package DAO;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.kimbabDTO;

public class kimbab implements allDAO {

	Scanner in = new Scanner(System.in);

	ArrayList<kimbabDTO> klist = new ArrayList<>();



	@Override
	public void exp() {
		// TODO Auto-generated method stub
		System.out.println("¿·±¸¸®°¡ ÅÍÁ®¾ß Á¦¸ÀÀÌÁö");
	}

	@Override
	public void bask() {
		// TODO Auto-generated method stub
		
		kimbabDTO kb = new kimbabDTO();

		System.out.println("¹«½¼ ±è¹äÀÔ´Ï±î?");
		System.out.println("ÀÏ  ¹İ ±è¹ä  2000¿ø");
		System.out.println("Âü  Ä¡ ±è¹ä  3000¿ø");
		System.out.println("µ·±î½º ±è¹ä  3000¿ø");
		String bsel = in.nextLine();
		if (same(bsel) == 1) {
			System.out.println("¸î ÁÙ ÇÒ±î¿ä?");
			int csel = in.nextInt();
			in.nextLine();

			kb.setSkim(bsel);
			kb.setCcnt(csel);

			klist.add(kb);
		}
	}

	public int same(String bsel) {
		if (bsel.equals("ÂüÄ¡")) {
			return 1;
		} else if (bsel.equals("ÀÏ¹İ")) {
			return 1;
		} else if (bsel.equals("µ·±î½º")) {
			return 1;
		} else {
			System.out.println("Àß¸ø ÀÔ·ÂÇÏ¿´½À´Ï´Ù.");
			return 2;
		}
	}

	@Override
	public void calc() {
		// TODO Auto-generated method stub
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(int i = 0; i < klist.size(); i++) {
			if("ÂüÄ¡".equals(klist.get(i).getSkim())) {
				sum1+=klist.get(i).getCcnt();
			} else if("ÀÏ¹İ".equals(klist.get(i).getSkim())) {
				sum2+=klist.get(i).getCcnt();
			} else if("µ·±î½º".equals(klist.get(i).getSkim())) {
				sum3+=klist.get(i).getCcnt();
			}
		}
		System.out.println("ÀÏ  ¹İ ±è¹ä ÃÑ"+sum2+"ÁÙ "+(sum2*2000)+"¿ø");
		System.out.println("Âü  Ä¡ ±è¹ä ÃÑ"+sum1+"ÁÙ "+(sum1*3000)+"¿ø");
		System.out.println("µ·±î½º ±è¹ä ÃÑ"+sum3+"ÁÙ "+(sum3*3000)+"¿ø");
	}

}
