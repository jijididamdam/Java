package main;

import java.util.ArrayList;

import parking.CompactCar;
import parking.MainCar_super;

public class ParkingM {
	//�ڵ����� ������ ����Ʈ�� �ϳ� ����
	private ArrayList<MainCar_super> carList = new ArrayList<>();
	
	public ParkingM() {
		//���������
		MainCar_super newCompact = new CompactCar();
		//��ü�� �����Ǹ鼭 �����ڿ� �ִ� �ڵ�� ���ؼ� �⺻ �����ᰡ ������.
		newCompact.setCarId("����1");
		
	}

}
