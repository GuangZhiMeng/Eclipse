package sort;

import java.util.Arrays;

public class BubbleSort2 {

	// 冒泡排序
	public static void main(String[] args) {
		// 新建一个数组，按照从小到大的顺序排序
		int[] arr = {22,55,44,33,11};
		
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		
		// 排序
		bubbleSort(arr);
		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));
	}

	// 将冒泡排序封装成一个方法
	public static void bubbleSort(int[] arr) {
		// 临时变量 用来交换数据
		int temp = 0;
		boolean flag = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(!flag) {
				break;
			} else {
				flag = false;
			}
		}
	}
}
