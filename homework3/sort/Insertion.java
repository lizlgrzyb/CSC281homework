package sort;

public class Insertion{
public static int descendingCounter;
public static int ascendingCounter;


  public static int[] descending(int[] array){
    int itemsSorted;
    int currentNum;
    int i;
    descendingCounter=0;
  
    for (itemsSorted = 1; itemsSorted < array.length; itemsSorted++){  //iterate through array
      currentNum = array[itemsSorted]; //counts
        descendingCounter += 1;
      for(i = itemsSorted - 1; (i >= 0) && (array[i] < currentNum); i--){
        array[ i+1 ] = array[i]; //counts
          descendingCounter += 1;
      }
    array[ i+1 ] = currentNum; //counts
      descendingCounter += 1;
    }
 
    return array;
  }


public static int[] ascending(int[] array){
  int i, j, newValue;
  ascendingCounter=0;
  for (i = 1; i < array.length; i++) {
    newValue = array[i]; //counts
      ascendingCounter +=1;
    j = i;
    while (j > 0 && array[j - 1] > newValue) {
      array[j] = array[j - 1]; //counts
        descendingCounter += 1;
      j--;
    }
    array[j] = newValue; //counts
      descendingCounter += 1;
  }
  return array;

}
}
