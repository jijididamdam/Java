package ex01;

import java.util.ArrayList;

public class CarADM extends CarManager {
	CarManager scm = new SoCar();
	CarManager jcm = new JungCar();
	CarManager dcm = new DaeCar();
	ArrayList<CarManager> clist = new ArrayList<>();
	
	//차량 등록
	
	public void setCar() {
		System.out.println("차량등록번호(5글자)를 입력해주세요");
		String setcar=in.nextLine();
		getGreen(setcar);
		System.out.println("등록날짜(년월일)를 입력해주세요");
		String setday=in.nextLine();
		getDay(setcar,setday);
		System.out.println("");
		
	}
	
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
			clist.add(scm);
		} else if(setcar.startsWith("3")||setcar.startsWith("4")) {
			jcm.cartype=setcar;
			clist.add(jcm);
		} else if(setcar.startsWith("5")||setcar.startsWith("5")) {
			dcm.cartype=setcar;
			clist.add(dcm);
		}
	}
	
	void getDay(String setcar,String setday) {
		if(setcar.startsWith("1")||setcar.startsWith("2")) {
			scm.day=setday;
			clist.add(scm);
		} else if(setcar.startsWith("3")||setcar.startsWith("4")) {
			jcm.day=setday;
			clist.add(jcm);
		} else if(setcar.startsWith("5")||setcar.startsWith("5")) {
			dcm.day=setday;
			clist.add(dcm);
		}
		
	}



	
	

}
