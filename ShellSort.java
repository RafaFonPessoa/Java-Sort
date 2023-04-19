import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        int array [] = {3, 5, 1, 6, 7, 4, 9, 8, 2, 10};

        System.out.print("Seu array antes de ser ordenado: " + Arrays.toString(array));
        System.out.println("");

        ss.sort(array);

        System.out.print("Seu array ordenado: " + Arrays.toString(array));
    }
}



class ShellSort {

    int sort(int arr[]) {
        int n = arr.length;

        // Começa com um grande gap, depois reduz o gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Faz uma classificação de inserção com intervalo para este tamanho de intervalo.
            // Os primeiros elementos de gap a[0..gap-1] já estão
            // em ordem de lacunas, continue adicionando mais um elemento
            // até que todos array seja classificado por intervalo
            for (int i = gap; i < n; i += 1) {

                // adiciona a[i] aos elementos que foram separados
                // ordenado, salve a[i] in temp e faça um furo em
                // posição i
                int temp = arr[i];

                // desloca os elementos classificados com intervalos anteriores até
                // o local correto para a[i] é encontrado
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                }

                // coloca temp (o original a[i]) em seu correto
                // localização
                arr[j] = temp;
            }
        }
        return 0;
    }
}
