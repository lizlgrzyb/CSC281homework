/**
 * 
 * @author Arianna Liles, Brianna Ngo, Medina Nurmanova
 *
 */
package sort; 


public class Bubble{
  public static int descendingCounter;
  public static int ascendingCounter;

	
  public static void Descending(int[] intArray) {
    int n = intArray.length;
    int temp = 0;
    descendingCounter = 0;

               
    for(int i=0; i < n; i++){
      for(int j=1; j < (n-i); j++){
        if(intArray[j-1] < intArray[j]){
          temp = intArray[j-1]; //counts
            descendingCounter += 1;
          intArray[j-1] = intArray[j]; //counts
            descendingCounter += 1;
          intArray[j] = temp; //counts
            descendingCounter += 1;
        }                      
      }
    }
    for(int j = 0; j < intArray.length; j++){
        System.out.print(intArray[j] + " ");
      }
  }





  public static void Ascending(int[] intArray) {
	  int n = intArray.length;
	  int temp = 0;
          ascendingCounter=0;

	              
	  for(int i=0; i < n; i++){
	      for(int j=1; j < (n-i); j++){
	        if(intArray[j-1] > intArray[j]){
	          temp = intArray[j]; //counts
                    ascendingCounter += 1;
	          intArray[j] = intArray[j - 1]; //counts
                    ascendingCounter += 1;
	          intArray[j - 1] = temp; //counts
                    ascendingCounter += 1;
	        }                      
	      }
	    }
	  for(int j = 0; j < intArray.length; j++){
	        System.out.print(intArray[j] + " ");
	     }
  }
}
 
