package quickSort;

@SuppressWarnings("unchecked")
public class QuickSort {

	public static void sort(Comparable a[]) {
		quick(a, 0, a.length - 1);
	}

	public static void quick(Comparable a[], int start, int end) {
		Comparable aux;
		int tam = end - start;
		if (tam <= 2) { // caso base

			if ((tam != 0)) {
				if (a[end].compareTo(a[start]) <= 0) {
					aux = a[end];
					a[end] = a[start];
					a[start] = aux;
				}
			}

		} else {
			Comparable escolhido = a[(start + end) / 2];
			int i, j;
			i = start; // . ,
			j = end; // 6 4 3 2 8 9
			while (i <= j) {
				if (escolhido.compareTo(a[i]) > 0) { // escolhido é maior que
														// a[i] ?
					i++;
				} else if (escolhido.compareTo(a[j]) < 0) { // escolhido é menor
															// que a[j] ?
					j--;
				} else {
					aux = a[j];
					a[j] = a[i];

					a[i] = aux;
					i++;
					j--;
				}
			}

			if (start < j) {
				quick(a, start, j);
			}
			if (i < end) {
				quick(a, i, end);
			}
		}

	}

	public static void main(String[] args) {
		Comparable dados[] = { 1, 3, 5, 2, 4, 6, 9, 7 };
		QuickSort.sort(dados);
		for (int a = 0; a < 8; a++)
			System.out.print(dados[a] + " ");
	}

}
