package parking;

import java.util.ArrayList;

public abstract class MainCar_super {
	String carId=null;
	int pay=0;
	boolean low_mission=false;
	int familyCnt=1;
	String indate=null; // 20220920
	ArrayList<Integer> payList = new ArrayList<>();
	//�����Ḧ �����ϸ� �ش� ���� payList�� add�ȴ�.
	
	public void setdata( boolean low_mission, int familyCnt, String indate) {
		this.low_mission=low_mission;
		this.familyCnt=familyCnt;
		this.indate=indate;
	}
	
	public void setCarId(String carId) {
		this.carId = carId;
	}
	
	public void discount1() {
		if(low_mission) {
			pay/=2;
		}
	}
	
	public abstract void discount2();
	

}
