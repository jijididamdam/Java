package ex01;

public class DaeCar extends CarManager {
	
	@Override
	public void getCartype(String cartype) {
		// TODO Auto-generated method stub
		if(cartype.endsWith("8")) {			
			this.cartype=cartype+"(������)";
			System.out.println("������(������)�� ��ϵǾ����ϴ�.");
		} else {
			this.cartype=cartype;
			System.out.println("�������� ��ϵǾ����ϴ�.");
		}
	}


}
