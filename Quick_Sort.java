import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();

        int[] array = {5, 10, 4, 2, 3, 8, 9, 6, 7, 1};

        qs.quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}

class QuickSort {
    
    void quickSort(int[] arr, int beg, int end) {
        if (beg < end) {
            int pi = partition(arr, beg, end);
            quickSort(arr, beg, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    static int partition(int[] arr, int beg, int end) {
        int pivot = arr[end];
        int i = (beg - 1);

        for (int j = beg; j <= end - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, end);
        return (i + 1);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
