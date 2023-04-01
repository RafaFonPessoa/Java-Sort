import java.util.Arrays;

public class Merge_Sort {

    public static void main(String[] args) {
        int[] array = {5, 10, 4, 2, 3, 8, 9, 6, 7, 1};

        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }


    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Divide o array em duas partes
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Combina as partes ordenadas em um único array ordenado
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copia os elementos dos subarrays para os arrays auxiliares
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Combina os subarrays em um único array ordenado
        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copia os elementos restantes do subarray esquerdo, se houver
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Copia os elementos restantes do subarray direito, se houver
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
