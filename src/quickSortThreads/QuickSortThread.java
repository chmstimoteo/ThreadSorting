package quickSortThreads;

import quickSort.QuickSort;

@SuppressWarnings("unchecked")
public class QuickSortThread extends Thread{
	
	private int numThreads;
	private Comparable[] a;
	private int start;
	private int end;
	
	public QuickSortThread(Comparable a[], int start, int end,int numThreads){
		this.a = a;
		this.end = end;
		this.start = start;
		this.numThreads = numThreads;
	}
	
	
	public void run() {
		Comparable aux;
		int tam = end - start;
		if (tam <= 2){					// caso base
			if ((tam != 0)) {
				if (a[end].compareTo(a[start]) <= 0) {
					aux=a[end];
					a[end]=a[start];
					a[start]=aux;
				}
			}
		} else	{
			Comparable escolhido = a[(start+end)/2];
			int i,j;									
			i = start;									//       . ,             
			j = end;									// 6 4 3 2 8 9
			while(i<=j){
				if(escolhido.compareTo(a[i]) > 0) {		// escolhido é maior que a[i] ?
					i++;
				} else if(escolhido.compareTo(a[j]) < 0) {	// escolhido é menor que a[j] ?
					j--;
				} else{
					aux=a[j];
					a[j]=a[i];
					a[i]=aux;
					i++;
					j--;
				}
			}

			if (Thread.activeCount()<=this.numThreads) {
				QuickSortThread thread1 = null, thread2 = null;
				if (start < j) {
					thread1 = new QuickSortThread(a, start, j,numThreads);
					thread1.start();
				}
				if (i < end) {
					thread2 = new QuickSortThread(a, i, end,numThreads);
					thread2.start();
				}
				try {
					if (start < j) {
						thread1.join();
					}
					if (i < end) {
						thread2.join();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				if (start < j) {
					QuickSort.quick(a,start,j);
				}
				if (i <end) {
					QuickSort.quick(a,i,end);
				}
			}
			
		}
	}
}
