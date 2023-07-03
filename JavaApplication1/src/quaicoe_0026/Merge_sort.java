
package quaicoe_0026;



import java.util.Arrays;


public class Merge_sort {
    
    
    public static void sorting(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sorting(array, left, mid);
            sorting(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
    
    public static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        
        while (j <= right) {
            temp[k++] = array[j++];
        }
        
        for (i = left, k = 0; i <= right; i++, k++) {
            array[i] = temp[k];
        }
    }
    
   
}

