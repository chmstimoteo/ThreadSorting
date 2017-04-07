package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import mergeSort.TempoMergeSort;
import mergeSortThreads.TempoMergeSortThreads;
import quickSort.TempoQuickSort;
import quickSortThreads.TempoQuickSortThreads;

public class Ordering implements IOrderingAlgorithms{

	@SuppressWarnings("unchecked")
	@Override
	public Long proccessAlgorithm(EOrderingAlgorithm algorithm,
			int numberOfThreads, String sourceFile) {
		Comparable[] dados = fileToArray(sourceFile);
		switch (algorithm) {
			case QuickSort: return TempoQuickSort.tempo(dados);
			case MergeSort: return TempoMergeSort.tempo(dados);
			case QuickSortThreads: return TempoQuickSortThreads.tempo(dados,numberOfThreads);
			case MergeSortThreads: return TempoMergeSortThreads.tempo(dados,numberOfThreads);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private Comparable[] fileToArray(String file){
		try {
		        BufferedReader in = new BufferedReader(new FileReader(file));
		            String str;
		            while (in.ready()) {
		                str = in.readLine();
		                String[] aux = str.split(" ");
		                Comparable[] array = new Comparable[aux.length];
		                for (int i = 0; i < aux.length; i++) {
		                	array[i] = new Integer(aux[i]);
						}
		                return array;
		            }
		            in.close();
		    } catch (IOException e) {
		}
		return null;
	}
}
