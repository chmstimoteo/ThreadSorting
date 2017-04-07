package mergeSortThreads;

import quickSort.QuickSort;
import mergeSort.MergeSort;

@SuppressWarnings("unchecked")
public class MergeSortThread extends Thread{
	private final static int TAM_MIN = 2;
	//private final static int NUM_THREADS = 2;
	private Comparable[] dados;
	private int numThreads;
	
	public MergeSortThread(Comparable[] dados, int numThreads){
		this.dados = dados;
		this.numThreads = numThreads;
	}
	public void run() {
		if (dados.length <= TAM_MIN)
			QuickSort.sort(dados);
		else {
			int meio = dados.length/2;				// metade do array
			Comparable a[] = new Comparable[meio];
			Comparable b[] = new Comparable[dados.length - meio];
			MergeSortThreads.copy(dados,0,meio-1,a);
			MergeSortThreads.copy(dados,meio,dados.length-1,b);
			if (Thread.activeCount()<= this.numThreads) {
				MergeSortThread thread1 = null, thread2 = null;
				thread1 = new MergeSortThread(a,this.numThreads);
				thread1.start();
				thread2 = new MergeSortThread(b,this.numThreads);
				thread2.start();
				try {
					thread1.join();
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				MergeSort.sort(a);
				MergeSort.sort(b);
			}
			MergeSortThreads.merge(a,b,dados);
		}
	}
}
