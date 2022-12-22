package Day15;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 라.1부터 9999까지 숫자를 모두 더하시오.
		int sum = 0;

		for (int i = 1; i < 10000; i++) {
			//for (int j = 10; j > 0;) {
			
			
				sum += (i % j);
				if (i / j == 0) {
					sum+=(i%j);
				}
			}
		}
		System.out.println(sum);

	}

}
