/**
 * 
 * @author Arianna Liles, Brianna Ngo, Medina Nurmanova
 *
 */
package sort; 

/**This section keeps track of the number of assignments and sends
 * the value back to be printed. 
 * @param bubbleCountD and @param bubbleCountA are counters to keep track of the number
 * of assignments
 */
public class Bubble{

  public static void Descending(int[] intArray) {
    int n = intArray.length;
    int temp = 0;
    int bubbleCountD = 0; //Variable to count assignments
               
    for(int i=0; i < n; i++){
      for(int j=1; j < (n-i); j++){
        if(intArray[j-1] < intArray[j]){
	  bubbleCountD++; //Adding to assignment count
          temp = intArray[j-1];
          intArray[j-1] = intArray[j];
          intArray[j] = temp;
        }                      
      }
    }
    System.out.print(bubbleCountD + " ");
      
  }
  public static void Ascending(int[] intArray) {
	  int n = intArray.length;
	  int temp = 0;
	  int bubbleCountA = 0;
	              
	  for(int i=0; i < n; i++){
	      for(int j=1; j < (n-i); j++){
	        if(intArray[j-1] > intArray[j]){
	          bubbleCountA++;
	          temp = intArray[j];
	          intArray[j] = intArray[j - 1];
	          intArray[j - 1] = temp;
	        }                      
	      }
	    }
	   System.out.print(bubbleCountA + " "); 
  }
}
 
