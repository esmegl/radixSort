import java.util.Arrays;
import java.util.ArrayList;


public class RadixSort{

	//Suppress the warning for generic array warnings
	@SuppressWarnings("unchecked")

	public static ArrayList<String> radixSort(int[] arr) {

		//Create sArr that will contain arr elements converted to strings
		ArrayList<String> sArr = new ArrayList<String>(arr.length);

		//Initialize the list
		for(int val : arr) {
			sArr.add("");
		}

		//Initializes the maximum number length
		int maxLen = 0;


		//Checks the length of the biggest number
		for(int num : arr) {
			String strNum = String.valueOf(num);

			if(maxLen < strNum.length())
				maxLen = strNum.length();
		}

		//Scope
		{
			int i = 0;

			//Convert to string and add leading zeros 
			for(int z : arr) {
				sArr.set(i++, String.format("%0" + String.valueOf(maxLen) + "d", z));
				//Check print
				// System.out.println(sArr.get(i-1));
			}
		}

		//Main loop
		//delta determines the position of the digit I'm checking
		for(int delta = 1; delta <= maxLen; delta++){

			//Create an array that will contain 10 lists
			ArrayList<String>[] lArr = new ArrayList[10];

			//Initialize the list
			for(int i = 0; i < lArr.length; i++) {
				lArr[i] = new ArrayList<String>();
			}


			//Add numbers to the correspondant list
			int aux = 0;
			for(String sNum : sArr) {
				aux = Character.getNumericValue(sNum.charAt(maxLen-delta));
				lArr[aux].add(sNum);
				//Debug
				// System.out.println("aux is: " + aux);
			}

			//Clear the list to add the new order
			sArr.clear();

			//Add all the elements in the new order
			for(ArrayList<String> list : lArr) {
				sArr.addAll(list);
			}


		}

		//Show the list
		for(String slist : sArr) {
					System.out.println(slist);
		}


		return sArr;

	} 

	public static void main(String[] args) {
		// int arr[] = {16223, 898, 13, 906, 235, 23, 9, 1532, 6388, 2511, 8};
		int arr[] = {90, 348, 34556, 2342, 607, 230, 3, 99, 1000000};
		// int arr[] = {3, 673, 106, 45, 2, 23};
		radixSort(arr);

	}
}