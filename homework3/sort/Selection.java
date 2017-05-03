package sort; 


public class Selection {
  public static int ascendingCounter;
  public static int descendingCounter;
 
  public static int[] ascending(int a[]) {
    int n = a.length;
    ascendingCounter=0;

    for (int i = 0; i < n-1; i++) {
      int q = i;  
      for (int j = i+1; j < n; j++) {
        if (a[j] < a[q]) {
          q = j; 
        } 
      }
    int temp = a[i]; //counts
      ascendingCounter +=1; 
    a[i] = a[q]; //counts
      ascendingCounter +=1;
    a[q] = temp; //counts
      ascendingCounter +=1;
    } 
   return a; 
 } 
  
  public static int[] descending(int a[]) {
    int n = a.length;
    descendingCounter=0;

    for (int i = 0; i < n-1; i++) {
      int q = i;  
    for (int j = i+1; j < n; j++) {
      if (a[j] > a[q]) {
        q = j; 
      }
    }
    int temp = a[i]; //counts
      descendingCounter += 1;
    a[i] = a[q]; //counts
      descendingCounter += 1;
    a[q] = temp; //counts;
      descendingCounter += 1;
    } 
    return a;
  } 
  
} 
//Group 1: Rebecca, Alex, Anna, Layla
	
