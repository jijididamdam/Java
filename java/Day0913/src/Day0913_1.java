
public class Day0913_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 54, 23, 23, 53, 87 }, { 3, 21, 55, 90, 27 }, { 2, 32, 22, 18, 65 }, { 32, 39, 12, 33, 94 } };

		int sRow = 0;
		int sLine = 0;
		int mRow = 3;
		int mLine = 4;
		int var = 0;


		//for (int k = 0; k <=4; k++) {
		for (int i=0; i<5; i++) {	
		for (int j = 0; j <4; j++) {
			//for ( int i = j+1; i<5; i++) {		
					var = a[sRow][j]; 
					a[sRow][j+1] = var;
					}
		}


		for (int h = 0; h < 4; h++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[h][j] + "\t");
			}
			System.out.println();
		}

	}

}
