package mergeSort;

@SuppressWarnings("unchecked")
public class TempoMergeSort {
	
	public static Long tempo (Comparable[] dados) {
		long tempo = 0;
		Comparable[] dadosClone = dados;
		dadosClone = (Comparable[]) dados.clone();
		tempo = System.nanoTime();	
		MergeSort.sort(dadosClone);
		return new Long(System.nanoTime() - tempo);
	}
}
