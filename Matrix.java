/**
* Standard Matrix class. 
* Created by Jennifer Hsu on June 11 2017
*/
import java.util.Random; 
public class Matrix{

	private int M; // Number of rows
	private int N; // Number of columns 
	private double[][] data; // M-by-N array 

	// Create M-by-N matrix of 0's 
	public Matrix(int M, int N){
		this.M = M; 
		this.N = N; 
		data = new double[M][N]; 
	}

	// Create matrix based on 2d array 
	public Matrix(double[][] data){
		M = data.length; 
		N = data[0].length; 
		this.data = new double[M][N]; 
		for(int i = 0; i<M ;i++){
			for(int j = 0; j< N; j++){
				this.data[i][j] = data[i][j]; 
			}
		}
	}
	// Create and return a random M-by-N matrix with values between 0 and 1 
	public static Matrix randomMatrix(int m, int n){
		Random rand = new Random(); 
		Matrix result = new Matrix(m, n); 
		for(int i=0; i<m ;i++){
			for(int j=0; j<n; j++){
				result.data[i][j] = rand.nextGaussian(); 
			}
		}
		return result; 
	}
 
 	// Return C = A + B
 	public Matrix plus(Matrix B){
 		Matrix A = this; 
 		if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions"); 
 		Matrix C = new Matrix(M, N); 
 		for(int i=0; i<M; i++){
 			for(int j=0; j<N; j++){
 				C.data[i][j] = A.data[i][j] + B.data[i][j]; 
 			}
 		}
 	}

 	// Return C = A - B
 	public Matrix minus(Matrix B){
 		Matrix A = this; 
 		if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions"); 
 		Matrix C = new Matrix(M, N); 
 		for(int i=0; i<M; i++){
 			for(int j=0; j<N; j++){
 				C.data[i][j] = A.data[i][j] - B.data[i][j]; 
 			}
 		}
 	}
	// Return C = A*B
	public Matrix times(Matrix B){
		Matrix A = this; 
		if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions"); 
		Matrix C = new Matrix(M,N); 
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<A.N; k++)
					C.data[i][j] += (A.data[i][k] + B.data[k][j]); 
			}
		}
	}

	// Return C = A*x, with x being a double. 
	public Matrix times(double x){
		double[][] temp = new double[N][1]; 
		for(int i=0; i<N; i++){
			temp[i][0] = x; 
		}
		Matrix C = new Matrix(temp); 
		return C; 
	}
	/*
	* Modifiers and Accessors
	*/
	// Accessor 
	public double getValue(int x, int y){
		if(x >= M || x < 0 || y >= N || y < 0)
			throw new ArrayIndexOutOfBoundsException("Array Index out of bounds"); 
		return this.data[x][y]; 
	}

	public double getM(){
		return this.M; 
	}

	public double getN(){
		return this.N; 
	}

	public double[][] get2dArray(){
		return this.data; 
	}
}