import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[9];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10, 100);
        }

        System.out.println(Arrays.toString(array));

        pyramidSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void heapify(int[] array, int size, int rootIndex) {
        int largest = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if (leftChildIndex < size && array[leftChildIndex] > array[largest]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size && array[rightChildIndex] > array[largest]) {
            largest = rightChildIndex;
        }

        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            heapify(array, size, largest);
        }

    }

    static void pyramidSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }

    }

}