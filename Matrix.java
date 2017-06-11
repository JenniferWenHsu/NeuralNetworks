import java.util.Random; 
public class Matrix{
	// Returns a random m-by-n matrix with values between 0 and 1 
	public static double[][] randomMatrix(int m, int n){
		double[][] a = new double[m][n]; 
		Random rand = new Random(); 
		for(int i=0; i<m; i++)
			for(int j=0; j<n; j++)
				a[i][j] = rand.nextGaussian(); 
		return a; 
	}
}