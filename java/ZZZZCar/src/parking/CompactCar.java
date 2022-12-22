package parking;

public class CompactCar extends MainCar_super {

	@Override
	public void discount2() {
		// TODO Auto-generated method stub
		if(familyCnt>=4) {
			super.pay=(int)(super.pay*0.9);
		}
	}
	

}
