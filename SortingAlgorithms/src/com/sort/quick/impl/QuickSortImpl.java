package com.sort.quick.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSortImpl {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of integers in the array:");
		int size = Integer.parseInt(br.readLine());
		int[] array = new int[size];
		System.out.println("Enter " + size + " space separated integers:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; ++i) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		long start = System.nanoTime();
		quickSort(array, 0, size - 1);
		long end = System.nanoTime();
		print(array);
		System.out.println("The procedure took " + (double)(end - start) / 1000 + " microseconds.");
	}

	public static void quickSort(int[] arr, int p, int r) {
		if(p < r) {
			int q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	}
	
	static int partition(int[] arr, int p, int r) {
		int j = p, i = j - 1, pivot = arr[r];
		while(j < r) {
			if(arr[j] < pivot) {
				swap(arr, ++i, j);
			}
			++j;
		}
		swap(arr, ++i, r);
		return i;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void print(int[] arr) {
		System.out.println();
		for(int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
