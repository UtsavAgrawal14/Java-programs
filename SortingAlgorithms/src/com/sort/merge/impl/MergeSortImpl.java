package com.sort.merge.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSortImpl {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements in the array:");
		int size = Integer.parseInt(br.readLine());
		int[] array = new int[size];
		System.out.println("Enter " + size + " space separated integers:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; ++i) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		long start = System.nanoTime();
		mergeSort(array, 0, size - 1);
		long end = System.nanoTime();
		print(array);
		System.out.println("The procedure took " + (double)(end - start) / 1000 + " microseconds.");
	}
	
	public static void mergeSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}
	
	static void merge(int[] arr, int p, int q, int r) {
		int size1 = q - p + 1, size2 = r - q;
		int[] left = new int[size1 + 1], right = new int[size2 + 1];
		for(int i = 0; i < size1; ++i) {
			left[i] = arr[p + i];
		}
		left[size1] = Integer.MAX_VALUE;
		for(int i = 0; i < size2; ++i) {
			right[i] = arr[q + i + 1];
		}
		right[size2] = Integer.MAX_VALUE;
		int i = 0, j = 0, k = 0; 
		while(k < (size1 + size2)) {
			if(left[i] < right[j]) {
				arr[p + k] = left[i++];
			}else if(right[j] < left[i]){
				arr[p + k] = right[j++];
			}else {
				arr[p + k++] = left[i++];
				arr[p + k] = right[j++];
			}
			++k;
		}
	}
	
	static void print(int[] array) {
		System.out.println();
		for(int elem : array) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
