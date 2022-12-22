package main;

import java.util.ArrayList;

import parking.CompactCar;
import parking.MainCar_super;

public class ParkingM {
	//자동차를 관리할 리스트를 하나 선언
	private ArrayList<MainCar_super> carList = new ArrayList<>();
	
	public ParkingM() {
		//소형차등록
		MainCar_super newCompact = new CompactCar();
		//객체가 생성되면서 생성자에 있는 코드로 인해서 기본 주차료가 설정됨.
		newCompact.setCarId("소형1");
		
	}

}
