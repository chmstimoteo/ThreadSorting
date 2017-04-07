package quickSortThreads;

@SuppressWarnings("unchecked")
public class TempoQuickSortThreads {

	public static Long tempo (Comparable[] dados,int numThreads) {
		long tempo = 0;
		Comparable[] dadosClone = dados;
		dadosClone = (Comparable[]) dados.clone();
		tempo = System.nanoTime();	
		QuickSortThreads.sort(dadosClone, numThreads);
		return new Long(System.nanoTime() - tempo);
	}

}
