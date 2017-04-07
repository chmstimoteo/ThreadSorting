package mergeSortThreads;

@SuppressWarnings("unchecked")
public class TempoMergeSortThreads {
	
	public static Long tempo (Comparable[] dados, int numThreads) {
		long tempo = 0;
		Comparable[] dadosClone = dados;
		dadosClone = (Comparable[]) dados.clone();
		tempo = System.nanoTime();	
		MergeSortThreads.sort(dadosClone, numThreads);
		return new Long(System.nanoTime() - tempo);
	}
}
