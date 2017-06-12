/**
* A module that implements a feed-forward neural networks using sigmoid neurons
* and stochastic gradient descent learning algorithm. 
* Created by Jennifer Hsu on June 10 2017
**/


//-------------------------------------------
// Standard library
import java.util.ArrayList; 
import java.lang.Math; 

public class Network{

	/*
	 *The int array SIZES contain the number of neurons in the respective 
	 *the respective layers of the network. 
	*/
	public Network(int[] sizes){
		int num_layers = sizes.length; 
		ArrayList<Matrix> biases = new ArrayList<Matrix>(); 
		ArrayList<Matrix> weights = new ArrayList<Matrix>(); 

		for(int i=0; i<sizes.length; i++){
			biases.add(Matrix.randomMatrix(i, 1));
		}

		ArrayList<ArrayList<Integer>> weight_size = new ArrayList<ArrayList<Integer>>(); 
		
		for(int i = 1; i<sizes.length; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>(); 
			temp.add(i); 
			temp.add(sizes.length - i);
			weight_size.add(temp); 
		}

		for(int i=0; i<weight_size.size(); i++){
			weights.add(Matrix.randomMatrix(weight_size.get(i).get(0), 
				weight_size.get(i).get(1))); 
		}
	}

	/*Return the output of the network if A is the input*/
	public static Matrix feedForward(Matrix A){
		if(biases.size() != weights.size()) 
			throw new RuntimeException("Size of biases does not match size of weights"); 
		for(int i=0; i<biases.size(); i++){
			A = sigmoid(biases.get(i).times(A) + weights.get(i)); 
		}

		return A; 
	}

	/*
	 * Train the neural network using the mini-batch stochastic gradient descent. 
	 * TRAINING_DATA is an ArrayList of tuples (x, y) representing the training
	 * inputs and the desired outputs. x is a n-by-1 matrix with n being the dimension
	 * of the input vector. 
	 *
	 * If TEST_DATA is provided, then the network will be evaluated against the test
	 * data after each epoch, and partial progress will be printed out. 
	 * May be deleted if needs to train at a faster speed.
	 * There are no differences in performance.  
	 */
	public static void stochastic_gradient_descent(
		ArrayList<Data> trainingData, int epochs, int miniBatchSize,
		double eta, ArrayList<Data> testData = null){
		// TODO

	}

	public static void update_mini_batch(ArrayList<Data> miniBatch, double eta){
		ArrayList<Matrix> nabla_b = new ArrayList<Matrix>(); 
		for(Matrix bias : biases){
			Matrix zeros_b = new Matrix(bias.getM(), bias.getN());
			nabla_b.add(zeros_b);   
		}

		ArrayList<Matrix> nabla_w = new ArrayList<Matrix>(); 
		for(Matrix bias : biases){
			Matrix zeros_w = new Matrix(bias.getM(), bias.getN()); 
			nabla_w.add(zeros_w); 
		}

		// TODO: Need to update biases and weights. 
		for(Data batch : miniBatch){
			ArrayList<ArrayList<Matrix>> delta = backPropagation(batch); 
			ArrayList<Matrix> delta_nabla_b = delta.get(0);
			ArrayList<Matrix> delta_nabla_w = delta.get(1);

			for(int i=0; i<delta_nabla_b.size(); i++){
				 nabla_b.set(i, delta_nabla_b.plus(nabla_b)); 
			}

			for(int i=0; i<delta_nabla_w.size(); i++){
				nabla_w.set(i, delta_nabla_w.plus(nabla_w)); 
			}
		}

		for(int i=0; i<weights.size();i++){
			Matrix w = weights.get(i); 
			Matrix nw = nabla_w.get(i); 

			weights.set(i, w.minus(nw.times(eta/miniBatch.size()))); 
		}

		for(int i=0; i<biases.size(); i++){
			Matrix b = biases.get(i); 
			Matrix nb = nabla_b.get(i); 

			biases.set(i, b.minus(nb.times(eta/miniBatch.size()))); 
		}

	}

	/*
	 * Return an ArrayList 
	 */
	public static ArrayList<Matrix> backPropagation(Data data){
		ArrayList<Matrix> nabla_b = new ArrayList<Matrix>(); 
		for(Matrix bias : biases){
			Matrix zeros_b = new Matrix(bias.getM(), bias.getN());
			nabla_b.add(zeros_b);   
		}

		ArrayList<Matrix> nabla_w = new ArrayList<Matrix>(); 
		for(Matrix bias : biases){
			Matrix zeros_w = new Matrix(bias.getM(), bias.getN()); 
			nabla_w.add(zeros_w); 
		}

		// TODO : The rest of the method
		ArrayList<ArrayList<Matrix>> result = new ArrayList<ArrayList<Matrix>>(); 
		return result; 

	}

	/*
	* Miscellaneous functions 
	*/

	// The sigmoid function 
	public Matrix sigmoid(Matrix z){
		double[][] 2darray = new double[z.getM()][1]; 
		for(int i=0; i<z.getM(); i++){
			2darray[i][0] = 1.0/(1.0 + Math.exp(-1*z.getValue(i, 0));
		}

		Matrix result = new Matrix(2darray); 
		return result; 
	}

	// Derivative of the sigmoid function 
	public Matrix sigmoid_prime(Matrix z){
		Matrix sigmoid = sigmoid(z); 
		double[][] 2darray = new double[z.getM()][1];
		double[][] 2dsigmoid = sigmoid.get2dArray();  
		for(int i=0; i<z.getM(); i++){
			2darray[i][0] = 2dsigmoid[i][0]*(1-2dsigmoid[i][0]); 
		}
		Matrix result = new Matrix(2darray); 
		return result;
	}

}