package Test_2;

public class Test_Miro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] miro = { {1,0,0,1,1,1,1,1},
						   {1,1,0,0,0,0,0,0},
						   {1,1,0,1,1,1,0,0},
						   {1,1,0,1,1,1,0,0},
						   {1,0,0,1,1,1,0,1},
						   {1,0,1,1,0,1,0,1},
						   {0,0,1,0,0,0,0,0},
						   {0,1,1,0,1,1,1,1}
		};
		
		/* 1. 행에서 0이 연속 4개 이상인 것 찾기
		 * 2. 열에서 0이 연속 4개 이상인 것 찾기
		 * 3. 겹치는 지점의 배열 출력
		 */
		int cnt=0;
		int ccnt=0;
	for(int t =0; t <8; t++) {
		for(int i = 0 ; i< 8; i++) {
			cnt=0;
			ccnt=0;
			for(int j=0; j<8; j++) {
				
				if(miro[j][i]==0) {					
					cnt++;
				} 
				if(miro[i][j]==0) {
					ccnt++;
				}
				
			}
			if(cnt>3) {
				System.out.print(i+",");
			}
		}
		System.out.println();
		/*for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(cnt>=4&&ccnt>=4) {
					System.out.println(i+","+j);
				}
			}
		}*/
		
	}

	}

}
