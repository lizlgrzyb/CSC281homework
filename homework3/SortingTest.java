/**
*@author Adam Carranza
*@since May 3, 2017
*/

import sort.*;
import java.util.Random;




public class SortingTest {
  private  enum SortDirection {
    ASCENDING,
    DESCENDING
  }

  
/**
*this method takes data from main and randomizes arrays
*@param either 10,100,1000 which is the limit of random values allowed per array instance
*/
  public static int[] randomArray(int g){
    int[]ar1 = new int[g];
    for (int i=0; i<ar1.length;i++) {
      Random rand = new Random();
      int randomNumber= rand.nextInt();
      ar1[i]=(int) randomNumber;
      }
    return ar1;
  }


  public static void main(String[] args) {
    SortingTest tester = new SortingTest(); //runs new blank SortingTest
    double ba10=0;
    double ba100=0; 
    double ba1000=0;
    double bd10=0; 
    double bd100=0;
    double bd1000=0;
    double sa10=0;
    double sa100=0;
    double sa1000=0;
    double sd10=0;
    double sd100=0;
    double sd1000=0;
    double ia10=0;
    double ia100=0;
    double ia1000=0;
    double id10=0;
    double id100=0;
    double id1000=0;


/**
* 10 randomized arrays for each of the 3 "testFor" created
* testAllSorters() assigns each instance of the radomized arrays to  empty variable
*/
    for(int i=0;i<10;i++) { //0-9    10 total
      int[] testFor10 =randomArray(10);
      int[] testFor100 =randomArray(100);
      int[] testFor1000 =randomArray(1000);
   


    tester.testAllSorters(testFor10);  //tests array
    ba10+= Bubble.ascendingCounter;
    bd10+= Bubble.descendingCounter;
    sa10+= Selection.ascendingCounter;
    sd10+= Selection.descendingCounter;
    ia10+= Insertion.ascendingCounter;
    id10+= Insertion.descendingCounter;


    tester.testAllSorters(testFor100);
    ba100+= Bubble.ascendingCounter;
    bd100+= Bubble.descendingCounter;
    sa100+= Selection.ascendingCounter;
    sd100+= Selection.descendingCounter;
    ia100+= Insertion.ascendingCounter;
    id100+= Insertion.descendingCounter;

  

    tester.testAllSorters(testFor1000);
    ba1000+= Bubble.ascendingCounter;
    bd1000+= Bubble.descendingCounter;
    sa1000+= Selection.ascendingCounter;
    sd1000+= Selection.descendingCounter;
    ia1000+= Insertion.ascendingCounter;
    id1000+= Insertion.descendingCounter;
}




// These divide arrays by 10 to output averages per sort type. ie the 10 bubble ascending(ba10) recorded are averaged.

    double averageBa10 = ba10/10.0;
    double averageBd10 = bd10/10.0;
    double averageBa100 = ba100/10.0;
    double averageBd100 = bd100/10.0;
    double averageBa1000 = ba1000/10.0;
    double averageBd1000 = bd1000/10.0;


   double averageSa10 = sa10/10.0;
    double averageSd10 = sd10/10.0;
    double averageSa100 = sa100/10.0;
    double averageSd100 = sd100/10.0;
    double averageSa1000 = sa1000/10.0;
    double averageSd1000 = sd1000/10.0;


    double averageIa10 = ia10/10.0;
    double averageId10 = id10/10.0;
    double averageIa100 = ia100/10.0;
    double averageId100 = id100/10.0;
    double averageIa1000 = ia1000/10.0;
    double averageId1000 = id1000/10.0;





//For your viewing pleasure


    System.out.println("Average assignments in 10 runs of Bubble  sort ascending for each case:");
    System.out.println("length 10: " +  ba10);
    System.out.println("length 100: " + ba100);
    System.out.println("length 1000: " + ba1000);

    System.out.println ("Average assignments in 10 runs of  Bubble sort descending for each case:");
    System.out.println("length 10: " + bd10);
    System.out.println("length 100: " + bd100);
    System.out.println("length 1000: " + bd1000);


    System.out.println("Average assignments in 10 runs of Selecting sort ascending for each case:");
    System.out.println("length 10: " + sa10);
    System.out.println("length 100: " + sa100);
    System.out.println("length 1000: " + sa1000);


    System.out.println ("Average assignments in 10 runs of Selecting sort descending for each case:");
    System.out.println("length 10: " + sd10);
    System.out.println("length 100: " + sd100);
    System.out.println("length 1000: " + sd1000);


    System.out.println ("Average assignments in 10 runs of Inserting  sort ascending for each case:");
    System.out.println("length 10: " + ia10);
    System.out.println("length 100: " + ia100);
    System.out.println("length 1000: " + ia1000);


    System.out.println ("Average assignments in 10 runs of Insertion sort descending for each case:");
    System.out.println("length 10: " + id10);
    System.out.println("length 100: " +id100);
    System.out.println("length 1000: " +id1000);

}
    /*




  private void testAllSorters(int[] data) {
    testBubbleAscending(data);
    testBubbleDescending(data);
    testInsertionAscending(data);
    testInsertionDescending(data);
    testSelectionAscending(data);
    testSelectionDescending(data);
   }






  private boolean testBubbleAscending(int[] data) {
    Bubble.Ascending(data);
    int[] check = {1, 2, 3, 4, 5};
    for (int i = 0; i < data.length; i++) {
    	if (data[i] != check[i]) {
    		return false;
    	}
    }
    return true;
  }
  
  private boolean testBubbleDescending(int[] data) {
    Bubble.Descending(data);
    int[] check = {5, 4, 3, 2, 1};
    for (int i = 0; i < data.length; i++) {
    	if (data[i] != check[i]) {
    		return false;
    	}
    }
    return true;
    
  }
  
  private boolean testSelectionAscending(int[] data) {
   Selection.ascending(data);
    int[] check = {1, 2, 3, 4, 5};
    for (int i = 0; i < data.length; i++) {
      if (data[i] != check[i]) {
        return false;
      }
    }
    return true; 
  }
  
  private boolean testSelectionDescending(int[] data) {
    Selection.descending(data);
    int[] check = {5, 4, 3, 2, 1};
    for (int i = 0; i < data.length; i++) {
      if (data[i] != check[i]) {
        return false;
      }
    }
    return true; 
  }

  private boolean testInsertionAscending(int[] data) {
    int[] sortedData = Insertion.ascending(data);
    boolean checkSort = isSorted(sortedData, SortDirection.ASCENDING);
    return checkSort;
  } 
  
  private boolean testInsertionDescending(int[] data) {
    int[] sortedData = Insertion.descending(data); 
    boolean checkSort = isSorted(sortedData, SortDirection.DESCENDING);
    return checkSort;
  }
  private boolean isSorted(int[] data, SortDirection direction) {

  if (direction == SortingTest.SortDirection.ASCENDING) {
    int n = data.length;

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (data[j - 1] > data[j]) {
						return false;
					}
				}
			}

  }
		if (direction == SortingTest.SortDirection.DESCENDING) {
			int n = data.length;

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (data[j - 1] < data[j]) {
						return false;
					}
				}
			}
		}
		return true;

	} 
}
*/
}
