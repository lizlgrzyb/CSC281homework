package sort;
/**This section keeps track of the number of assignments and sends
 * the value back to be printed. 
 * @param selectionCountD and @param selectionCountA are counters to keep track of the number
 * of assignments
 */

public class Insertion{
  
  public static int[] descending(int[] array){
    int itemsSorted;
    int currentNum;
    int i;  
    int insertionCountD = 0;

    for (itemsSorted = 1; itemsSorted < array.length; itemsSorted++){  //iterate through array
      currentNum = array[itemsSorted]; //sets the number we are sorting with next index
      insertionCountD++;
      for(i = itemsSorted - 1; (i >= 0) && (array[i] < currentNum); i--){
        array[ i+1 ] = array[i];
	
      }
    array[ i+1 ] = currentNum;
    }
 
    System.out.print("Assignments:" + " " + insertionCountD + " ");  
    return array;
  
  }

public static int[] ascending(int[] array){
  int i, j, newValue;
  int insertionCountA = 0;
  for (i = 1; i < array.length; i++) {
    newValue = array[i];
    j = i;
    insertionCountA++;
    while (j > 0 && array[j - 1] > newValue) {
      array[j] = array[j - 1];
      j--;
    }
    array[j] = newValue;
  }
  System.out.print("Assignments: " + insertionCountA + " ");
  return array;

}
}
