
public class Day02_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a = { { 54, 23, 23, 53, 87 }, { 3, 21, 55, 90, 27 }, { 2, 32, 22, 18, 65 }, { 32, 39, 12, 33, 94 } };
		/*
		 * За : a[i][j+1]=a[i][j] ї­ : a[i+1][j]=a[i][j]
		 */
		int sRow = 0;
		int sLine = 0;
		int mRow = 3;
		int mLine = 4;

		for (int i = mLine; i >= sLine; i--) {
			for (int t = mRow; t >= sRow; t--) {
				for (int k = sLine; k <= mLine; k++) {
					for (int l = sRow; l <= mRow; l++) {

						if (i > sLine && i <= mLine) {

							if (t > sRow && t < mRow) {

								if (k < mLine && k > sLine) {

									if (l > sRow && l < mRow) {
										a[sRow][i] = a[sRow][i - 1];
										a[t][mLine] = a[t - 1][mLine];
										a[mRow][k] = a[mRow][k + 1];

										a[l][sLine] = a[l + 1][sLine];
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
					}
				}
			}
		}
	}

}
