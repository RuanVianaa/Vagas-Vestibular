import java.util.List;

public class Sorts<T extends Comparable<T>> {

    // Algoritmo de ordenação (Quick Sort)
    public void sort(List<T> lista) {
        if (lista != null && lista.size() > 1) {
            quickSort(lista, 0, lista.size() - 1);
        }
    }

    private void quickSort(List<T> lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(lista, inicio, fim);
            quickSort(lista, inicio, pivoIndex - 1);
            quickSort(lista, pivoIndex + 1, fim);
        }
    }

    private int particionar(List<T> lista, int inicio, int fim) {
        T pivo = lista.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (lista.get(j).compareTo(pivo) <= 0) {
                i++;
                trocar(lista, i, j);
            }
        }
        trocar(lista, i + 1, fim);
        return i + 1;
    }

    private void trocar(List<T> lista, int i, int j) {
        T temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }
}