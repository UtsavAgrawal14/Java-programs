package com.sort.heap.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HeapSortImpl {

	static int heapSize;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements in the array:");
		int size = Integer.parseInt(br.readLine());
		int[] array = new int[size];
		System.out.println("Enter " + size + " space separated integers:");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; ++i) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		long start = System.nanoTime();
		array = heapSort(array, size);
		long end = System.nanoTime();
		print(array);
		System.out.println("The procedure took " + (double) (end - start) / 1000 + " microseconds.");
	}

	public static int[] heapSort(int[] array, int size) {
		int[] sorted = new int[size];
		heapSize = size;
		buildMinHeap(array, size);
		for (int i = 0; i < size; ++i) {
			sorted[i] = extractMin(array);
		}
		return sorted;
	}

	static void buildMinHeap(int[] arr, int size) {
		for (int i = size / 2 - 1; i >= 0; --i) {
			heapify(arr, size, i);
		}
	}

	static void heapify(int[] arr, int size, int index) {
		int left = 2 * index + 1, right = left + 1, smallest = index;
		if (left < size && arr[left] < arr[smallest])
			smallest = left;
		if (right < size && arr[right] < arr[smallest])
			smallest = right;
		if (smallest != index) {
			swap(arr, smallest, index);
			heapify(arr, size, smallest);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int extractMin(int[] arr) {
		int min = arr[0];
		arr[0] = arr[heapSize - 1];
		--heapSize;
		heapify(arr, heapSize, 0);
		return min;
	}

	static void print(int[] array) {
		System.out.println();
		for (int elem : array) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
