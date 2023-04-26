import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        ShellSortKnuth ss = new ShellSortKnuth();
        int array [] = {3, 5, 1, 6, 7, 4, 9, 8, 2, 10};

        System.out.print("Seu array antes de ser ordenado: " + Arrays.toString(array));
        System.out.println("");

        ss.sort(array);

        System.out.print("Seu array ordenado: " + Arrays.toString(array));
    }
}

class ShellSortKnuth {
    int sort(int arr[]) {
        int n = arr.length;

        // Define a sequência de lacunas de acordo com Knuth
        int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;
        }

        // Começa com a maior lacuna e reduz o gap
        while (gap > 0) {

            // Faz uma classificação de inserção com intervalo para este tamanho de intervalo.
            // Os primeiros elementos de gap a[0..gap-1] já estão
            // em ordem de lacunas, continue adicionando mais um elemento
            // até que todo array seja classificado por intevalo
            for (int i = gap; i < n; i++) {

                // adiciona a[i] aos elementos que foram separados
                // ordenado, salve a[i] in temp e faça um furo em
                // posição i
                int temp = arr[i];

                // desloca os elementos classificados com intervalos anteriores até
                // o local correto para a[i] é encontrado
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                // coloca temp (o original a[i]) em seu correto
                // localização
                arr[j] = temp;
            }

            // reduz o gap de acordo com a sequência de Knuth
            gap = (gap - 1) / 3;
        }
        return 0;
    }
}
