package Train;

public class T_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockADM s = new StockADM();
		s.prt();
		int tcnt=s.cc();
		System.out.println(tcnt);
		s.pc(1000);
		s.prt();
		s.save("id",100,200);
		s.prt();
	}

}
