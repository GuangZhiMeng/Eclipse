package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序
public class SelectSort {
	public static void main(String[] args) {
		int [] arr = {101, 34, 119, 1};
		
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));

        // 计算运行时间
		// Date data1 = new Date();
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String date1Str = simpleDateFormat.format(data1);
		// System.out.println("排序前的时间是=" + date1Str);
		
		selectSort(arr);
		
		// Date data2 = new Date();
		// String date2Str = simpleDateFormat.format(data2);
		// System.out.println("排序前的时间是=" + date2Str);
		
		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));
	}
	
	//选择排序
	public static void selectSort(int[] arr) {
		//选择排序时间复杂度是 O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			int min = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) { // 说明假定的最小值，并不是最小
					min = arr[j]; // 重置min
					minIndex = j; // 重置minIndex
				}
			}

			// 将最小值，放在arr[0], 即交换
			if (minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}

			//System.out.println("第"+(i+1)+"轮后~~");
			//System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		}
		
		
		/*
		//使用逐步推导的方式来，讲解选择排序
		//第1轮
		//原始的数组 ： 	101, 34, 119, 1
		//第一轮排序 :   	1, 34, 119, 101
		//算法 先简单--》 做复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决
		
		第1轮
		int minIndex = 0;
		int min = arr[0];
		for(int j = 0 + 1; j < arr.length; j++) {
			if (min > arr[j]) { //说明假定的最小值，并不是最小
				min = arr[j]; //重置min
				minIndex = j; //重置minIndex
			}
		}
		
		//将最小值，放在arr[0], 即交换
		if(minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}
		
		System.out.println("第1轮后~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		
		//第2轮
		minIndex = 1;
		min = arr[1];
		for (int j = 1 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // 说明假定的最小值，并不是最小
				min = arr[j]; // 重置min
				minIndex = j; // 重置minIndex
			}
		}

		// 将最小值，放在arr[0], 即交换
		if(minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("第2轮后~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        */
	}
}