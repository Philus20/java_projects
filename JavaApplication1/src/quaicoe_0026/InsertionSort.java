
package quaicoe_0026;


public class InsertionSort {
    
    static void sorting(int numbers[],int numberSize)
 {
     int i = 0;
     int j = 0;
     
     int temp = 0 ;//Temporary Variable for swap
     
     for(i = 1; i < numberSize ; i++){
            j = i;
       //Find index of smallest remaining element
     while (j > 0 && numbers[j] < numbers[j-1]){
     //Swap numbers[i] and numbers[indexSmallest]
          temp = numbers[j-1];
          numbers[j-1] = numbers[j];
          numbers[j] = temp ;
          j--;}
     }
 }   
    
    
    
}
