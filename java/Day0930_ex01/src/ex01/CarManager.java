package ex01;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class CarManager {
	CarADM ca = new CarADM();

	String cartype; // ���� �Է� �޼���� ���� ���������� �ƴ��� �Ǻ�
	int carnum;
	String day;
	int cntperson;
	int cnt = 0;
	
	Scanner in = new Scanner(System.in);
	
	void getGreen(String setcar) {
		if(setcar.endsWith("8")) {
			cartype=setcar+"(������)";
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
		System.out.println("����ȣ : "+carnum);
		System.out.println("��ϳ�¥ : "+day);
	}
	

	
	/*CarManager scm = new SoCar();
	CarManager jcm = new JungCar();
	CarManager dcm = new DaeCar();
	*/
	
	/*
	void getGreen(String setcar) {
		if(setcar.endsWith("8")) {
			cartype=setcar+"(������)";
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
