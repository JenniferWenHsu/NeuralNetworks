// network.java 

/**
* Created by Jennifer Hsu on June 10 2017
**/
public class Network{
	/**
	* The int array SIZES contain the number of neurons in the respective
	* the respective layers of the network. 
	*/
	public Network(int[] sizes){
		private int num_layers = sizes.size(); 
		private ArrayList<Matrix> biases = new ArrayList<Matrix>(); 
		private ArrayList<Matrix> weights = new ArrayList<Matrix>(); 
		Random rand = new Random(); 

		for(int i=0; i<sizes.size(); i++){
			biases.add(randomMatrix(i, 1));
		}

		ArrayList<ArrayList<int>> weight_size = new ArrayList<ArrayList<int>>(); 
		
		for(int i = 1; i<sizes.size(); i++){
			ArrayList<int> temp = new ArrayList<int>(); 
			temp.add(i); 
			temp.add(sizes.size() - i);
			weight_size.add(temp); 
		}

		for(int i=0; i<weight_size.size(); i++){
			weights.add(randomMatrix(weight_size.get(0)), weight_size.get(1)); 
		}
	}

	/**
	* Return the output of the network if A is the input
	*/


}