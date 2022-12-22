package ex01;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class CarManager {
	CarADM ca = new CarADM();

	String cartype; // 차종 입력 메서드는 조건 저공해인지 아닌지 판별
	int carnum;
	String day;
	int cntperson;
	int cnt = 0;
	
	Scanner in = new Scanner(System.in);
	
	void getGreen(String setcar) {
		if(setcar.endsWith("8")) {
			cartype=setcar+"(저공해)";
			getCartype(setcar);
		} else {
			getCartype(setcar);
		}
	}
	
	public void getCartype(String setcar) {
		if(setcar.startsWith("1")||setcar.startsWith("2")) {
			
		} else if(setcar.startsWith("3")||setcar.startsWith("4")) {
			
		} else if(setcar.startsWith("5")||setcar.startsWith("5")) {
			
		}
	}
	
	
	public void set(String cartype,int carnum, String day, int cntperson) {
		this.cartype=cartype;
		this.carnum=carnum;
		this.day=day;
		this.cntperson=cntperson;
	}
	
	public void prt() {
		System.out.println("차번호 : "+carnum);
		System.out.println("등록날짜 : "+day);
	}
	

	
	/*CarManager scm = new SoCar();
	CarManager jcm = new JungCar();
	CarManager dcm = new DaeCar();
	*/
	
	/*
	void getGreen(String setcar) {
		if(setcar.endsWith("8")) {
			cartype=setcar+"(저공해)";
			getCartype(setcar);
		} else {
			getCartype(setcar);
		}
	}
	
	
	public void getCartype(String setcar) {
		if(setcar.startsWith("1")||setcar.startsWith("2")) {
			scm.cartype=setcar;
		} else if(setcar.startsWith("3")||setcar.startsWith("4")) {
			jcm.cartype=setcar;
		} else if(setcar.startsWith("5")||setcar.startsWith("5")) {
			dcm.cartype=setcar;
		}
	}
	*/

	

}
