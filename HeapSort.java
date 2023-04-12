public class Main {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();

        int array[] = {3, 5, 8, 9, 4, 6, 2, 1, 7, 10};

        int n = array.length;

        hs.sort(array);

        System.out.println("O Seu array: ");
        hs.print(array);
    }
}

class HeapSort {
    //Vai ordenar o array
    public void sort(int arr[]){
        int n = arr.length;

        //Constroi o Heap
        for(int i = n / 2 - 1; i >= 0; i--)
        {
            heap(arr, n, i);
        }

        //Extrai os elementos os elementos do heap
        for(int i = n - 1; i > 0; i--)
        {
            //Move a raiz para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            //chama o heap maximo
            heap(arr, i, 0);
        }
    }

    // Para empilhar uma subárvore enraizada com o nó i que é  um índice em arr[]. n é o tamanho do heap
    void heap(int arr[], int n, int i){
        int largest = i; //inicia o largest como root
        int l = 2 * i + 1 ; //left
        int r = 2 * i + 2; //right

        // se o filho de left for maior que a raiz
        if(l < n && arr[l] > arr[largest])
        {
            largest = l;
        }

        //Se o filho de right for maior que o largest
        if(r < n && arr[r] > arr[largest])
        {
            largest = r;
        }

        //Se o largest não é uma raiz
        if(largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heap(arr, n, largest);
        }
    }

    static void print(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
