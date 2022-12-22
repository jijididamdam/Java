package Tetris;

public class Tetris_2 {
	int [] [] a = {
			{1,1,1,1},
			{0,0,0,1},
			{0,0,0,1},
			{0,0,0,1}				
	};
	
	int [] [] b = {
			{2,2,0},
			{0,2,0},
			{0,2,2},				
	};
	Tetris_2() {
		r_totation(a);
	}
	
	
	public void r_totation (int [][] k) {
		for(int i =0; i <a.length ; i++) {
			for(int j=0; j<a[i].length; j++) {
				k[3-i][j]=a[i][j];
				//k[i][j]=a[i+1][j];
				System.out.print(k[3-i][j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
