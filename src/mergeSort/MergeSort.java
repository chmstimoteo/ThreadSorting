package mergeSort;

import quickSort.QuickSort;

@SuppressWarnings("unchecked")
public class MergeSort {
	
	private final static int TAM_MIN = 2;
	
	public static void sort(Comparable dados[]) {
		if (dados.length <= TAM_MIN)
			QuickSort.sort(dados);
		else {
			int meio = dados.length/2;				// metade do array
			Comparable a[] = new Comparable[meio];
			Comparable b[] = new Comparable[dados.length - meio];
			copy(dados,0,meio-1,a);
			copy(dados,meio,dados.length-1,b);
			
			sort(a);
			sort(b);
			
			merge(a,b,dados);
		}
		
	}
	
	private static void copy(Object[] dados, int inicio, int fim, Object[] b) {
		for (int x=inicio; x<=fim; x++)
			b[x-inicio] = dados[x];
	}

	private static void merge (Comparable a[], Comparable b[], Comparable dados[]) {
		int iA, iB, iDest;
		
		iA=iB=iDest=0;
		
		while (iA < a.length && iB < b.length)
			if (a[iA].compareTo(b[iB]) < 0)
				dados[iDest++] = a[iA++];
			else
				dados[iDest++] = b[iB++];
		
		while (iA < a.length)
			dados[iDest++] = a[iA++];
		while (iB < b.length)
			dados[iDest++] = b[iB++];

	}
	
	public static void main(String[] args){
		Comparable dados[] = {1,3,5,2,4,6,9,7};
		MergeSort.sort(dados);
		for(int a=0; a<8 ; a++)
			System.out.print(dados[a]+" ");
	}

}
