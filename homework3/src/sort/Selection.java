package sort; 

public class Selection { 
  public static int[] ascending(int a[]) {
    int n = a.length;
    int selectionCountA = 0;

    for (int i = 0; i < n-1; i++) {
      int q = i;
      selectionCountA++; 
      for (int j = i+1; j < n; j++) {
	selectionCountA++;
        if (a[j] < a[q]) {
          q = j; 
        } 
      }
    int temp = a[i]; 
    a[i] = a[q]; 
    a[q] = temp;  
    } 
   System.out.print("Assignments: " + selectionCountA + " ");
   return a; 
 } 
  
  public static int[] descending(int a[]) {
	    int n = a.length;
	    int selectionCountD = 0;

	    for (int i = 0; i < n-1; i++) {
	      int q = i;  
	      selectionCountD++;
	      for (int j = i+1; j < n; j++) {
		selectionCountD++;
	        if (a[j] > a[q]) {
	          q = j; 
	        } 
	      }
	    int temp = a[i]; 
	    a[i] = a[q]; 
	    a[q] = temp;  
	    } 
	   System.out.print("Assignments: " + selectionCountD + " ");
	   return a; 
	 } 
  
} 

//Group 1: Rebecca, Alex, Anna, Layla

