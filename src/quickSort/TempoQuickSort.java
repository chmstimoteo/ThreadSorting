package quickSort;

@SuppressWarnings("unchecked")
public class TempoQuickSort {

	public static Long tempo (Comparable[] dados) {
		long tempo = 0;
		Comparable[] dadosClone = dados;
		dadosClone = (Comparable[]) dados.clone();
		tempo = System.nanoTime();	
		QuickSort.sort(dadosClone);
		return new Long(System.nanoTime() - tempo);
	}
}
