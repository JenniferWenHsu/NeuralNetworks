public class Matrix{
	// Returns a random m-by-n matrix with values between 0 and 1 
	public static double[][] random(int m, int n){
		double[][] a = new double[m][n]; 
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				a[i][j] = StdRandom.uniform(0.0, 1.0); 
		return a; 
	}
}