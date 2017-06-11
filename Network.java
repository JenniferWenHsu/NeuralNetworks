// network.javainclud

import java.util.ArrayList; 

/**
* Created by Jennifer Hsu on June 10 2017
**/
public class Network{
	/**
	* The int array SIZES contain the number of neurons in the respective
	* the respective layers of the network. 
	*/
	public Network(int[] sizes){
		int num_layers = sizes.length; 
		ArrayList<double[][]> biases = new ArrayList<double[][]>(); 
		ArrayList<double[][]> weights = new ArrayList<double[][]>(); 

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

	/**
	* Return the output of the network if A is the input
	*/


}