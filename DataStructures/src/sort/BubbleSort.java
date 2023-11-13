package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {3,9,-1,10,-2};
		
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		
		// 测试冒泡排序
		bubbleSort(arr);
		
		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));
		
		
//		// 第二趟排序，将最大的数排在倒数第二位
//			int temp1 = 0;// 临时变量 用于交换数据
//			for (int j = 0; j < arr.length - 1-1; j++) {
//				// 如果前面的数比后面的数大，则交换
//				if (arr[j] > arr[j + 1]) {
//					temp1 = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp1;
//				}
//			}
//				
//			System.out.println("第二趟排序后的数组");
//			System.out.println(Arrays.toString(arr));
	}
	
	
	// 将前面冒泡排序算法，封装成一个方法
		public static void bubbleSort(int[] arr) {
			// 冒泡排序 的时间复杂度 O(n^2), 自己写出
			int temp = 0; // 临时变量
			boolean flag = false; // 标识变量，表示是否进行过交换
			for (int i = 0; i < arr.length - 1; i++) {

				for (int j = 0; j < arr.length - 1 - i; j++) {
					// 如果前面的数比后面的数大，则交换
					if (arr[j] > arr[j + 1]) {
						flag = true;
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
				//System.out.println("第" + (i + 1) + "趟排序后的数组");
				//System.out.println(Arrays.toString(arr));

				if (!flag) { // 在一趟排序中，一次交换都没有发生过
					break;
				} else {
					flag = false; // 重置flag!!!, 进行下次判断
				}
			}
		}

}
