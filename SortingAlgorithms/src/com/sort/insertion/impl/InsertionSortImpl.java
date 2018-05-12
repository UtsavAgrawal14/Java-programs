package com.sort.insertion.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSortImpl {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements in array:");
		int size = Integer.parseInt(br.readLine());
		int[] array = new int[size];
		System.out.println("Enter " + size + " space separated integers:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; ++i) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		long start = System.nanoTime();
		insertionSort(array, size);
		long end = System.nanoTime();
		print(array);
		System.out.println("The procedure took " + (double)(end - start) / 1000 + " microseconds.");
	}
	
	public static void insertionSort(int[] arr, int size) {
		
		for(int i = 1; i < size; ++i) {
			int temp = arr[i], j = i - 1;		
			while(j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				--j;
			}
			arr[j + 1] = temp;
		}
	}

	static void print(int[] arr) {
		System.out.println();
		for(int elem : arr) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
