package ex01;

public class SoCar extends CarManager {

	@Override
	public void getCartype(String cartype) {
		// TODO Auto-generated method stub
		if(cartype.endsWith("8")) {			
			this.cartype=cartype+"(저공해)";
			System.out.println("경차(저공해)로 등록되었습니다.");
		} else {
			this.cartype=cartype;
			System.out.println("경차로 등록되었습니다.");
		}
	}


	

}
