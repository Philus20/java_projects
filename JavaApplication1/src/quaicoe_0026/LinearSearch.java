
package quaicoe_0026;


public class LinearSearch {
           static int Searching(int numbers[], int numberSize, int key){
           int i = 0;
           for(i = 0; i < numberSize; ++i)
               if(numbers[i] == key){
               return i;
               }
               
           return -1;
           }
}
