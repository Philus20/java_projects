package quaicoe_0026;

public class BubbleSort {
    public void sorting(int numbers[], int numberSize) {
        for(int i = 0; i < numberSize - 1; i++) {
            for(int j = i + 1; j < numberSize; j++) {
                if(numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}