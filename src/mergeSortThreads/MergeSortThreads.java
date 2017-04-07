package mergeSortThreads;

import quickSort.QuickSort;

@SuppressWarnings("unchecked")
public class MergeSortThreads {
	
	private final static int TAM_MIN = 2;
	
	
	public static void sort(Comparable dados[], int numThreads) {
		if (dados.length <= TAM_MIN)
			QuickSort.sort(dados);
		else {
			int meio = dados.length/2;				// metade do array
			Comparable a[] = new Comparable[meio];
			Comparable b[] = new Comparable[dados.length - meio];
			copy(dados,0,meio-1,a);
			copy(dados,meio,dados.length-1,b);
			
			MergeSortThread thread1 = null, thread2 = null;
			thread1 = new MergeSortThread(a,numThreads);
			thread1.start();
			thread2 = new MergeSortThread(b,numThreads);
			thread2.start();
			try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			merge(a,b,dados);
		}
	}
	
	public static void copy(Object[] dados, int inicio, int fim, Object[] b) {
		for (int x=inicio; x<=fim; x++)
			b[x-inicio] = dados[x];
	}

	public static void merge (Comparable a[], Comparable b[], Comparable dados[]) {
		int iA, iB, iDest;
		iA=iB=iDest=0;
		while (iA < a.length && iB < b.length) {
			if (a[iA].compareTo(b[iB]) < 0) {
				dados[iDest++] = a[iA++];
			} else {
				dados[iDest++] = b[iB++];
			}
		}
		
		while (iA < a.length) {
			dados[iDest++] = a[iA++];
		}
		while (iB < b.length) {
			dados[iDest++] = b[iB++];
		}
	}
	
	/*@SuppressWarnings("static-access")
	public static void main(String[] args) {
		MergeSortThreads teste = new MergeSortThreads();
		Comparable[] array  = ArrayCreator.arrayDecrescente(10);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" , ");
		}
		System.out.println();
		teste.sort(array,2);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" , ");
		}
	}*/

}
