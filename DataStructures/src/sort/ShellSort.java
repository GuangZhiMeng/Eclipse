package sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
		shellSort(arr);
	}

	// 希尔排序——交换法
	public static void shellSort(int[] arr) {
		
		int temp = 0;// 用于交换
		int count = 0;// 记录循环轮数
		
		// 假设有10个数据 arr.length/2 = 5，gap/=2 》5/2 = 2,2/2 =1,1/2 = 0 不大于0
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素（共gap组，每组有2个元素），步长gap
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，说明需要交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
				
			}
			System.out.println("希尔排序第"+(++count)+"轮"+Arrays.toString(arr));
		}
		
		
		/*
		// 希尔排序的第1轮排序
		// 因为第1轮排序，是将10个数据分成了5组
		for (int i = 5; i < arr.length; i++) {
			// 遍历各组中所有的元素（共5组，每组有两个元素），步长5
			for (int j = i - 5; j >= 0; j -= 5) {
				// 如果当前元素大于加上步长后的那个元素，说明需要交换
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}
		System.out.println("希尔排序1轮后=" + Arrays.toString(arr));// [3, 5, 1, 6, 0, 8, 9, 4, 7, 2]

		
		// 希尔排序的第2轮排序
		// 因为第2轮排序，是将10个数据分成了5/2 = 2组
		for (int i = 2; i < arr.length; i++) {
			// 遍历各组中所有的元素（共5组，每组有2个元素），步长2
			for (int j = i - 2; j >= 0; j -= 2) {
				// 如果当前元素大于加上步长后的那个元素，说明需要交换
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}
		System.out.println("希尔排序2轮后=" + Arrays.toString(arr));// [0, 2, 1, 4, 3, 5, 7, 6, 9, 8]
		
		
		// 希尔排序的第3轮排序
		// 因为第3轮排序，是将10个数据分成了2/2 = 1组
		for (int i = 1; i < arr.length; i++) {
			// 遍历各组中所有的元素（共5组，每组有2个元素），步长1
			for (int j = i - 1; j >= 0; j -= 1) {
				// 如果当前元素大于加上步长后的那个元素，说明需要交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("希尔排序3轮后=" + Arrays.toString(arr));// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		*/
	}

}
