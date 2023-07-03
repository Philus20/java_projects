
package quaicoe_0026;


public class SelectionSort {
    
 static void sorting(int numbers[],int numberSize)
 {
     int i = 0;
     int j = 0;
     int indexSmallest = 0;
     int temp = 0 ;//Temporary Variable for swap
     
     for(i = 0; i < numberSize - 1; ++i){
     
       //Find index of smallest remaining element
     indexSmallest = i;
     for(j = i + 1; j < numberSize; ++j){
         if(numbers[j] < numbers[indexSmallest]){
         indexSmallest = j;
         }
     }
     //Swap numbers[i] and numbers[indexSmallest]
          temp = numbers[i];
          numbers[i] = numbers[indexSmallest];
          numbers[indexSmallest] = temp ;
     }
 }   
}
