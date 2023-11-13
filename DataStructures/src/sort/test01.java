package sort;

import java.util.Arrays;

public class test01 {

	public static void main(String[] args) {
		int[] arr = {9,3,7,6,2,4,8};
		
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("排序后");
		shellSort2(arr);
		System.out.println(Arrays.toString(arr));
	
	}
	
	// 希尔排序——移位法
	public static void shellSort2(int[] arr) {
		//增量gap 并逐步缩小增量
		for(int gap = arr.length /2; gap > 0; gap /= 2) {
			// 从第gap个元素开始，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				while(j - gap >= 0 && temp < arr[j - gap]) {
					//移动
					arr[j] = arr[j-gap];
					j -= gap;
				}
				//当退出while后，就给temp找到插入的位置
				arr[j] = temp;
			}
		}
	}
	
	
	// 希尔排序——交换法
	public static void shellSort(int[] arr) {
		int temp = 0;
		int count = 0;
		
		for(int gap = arr.length /2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if(arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
				System.out.println("希尔排序第"+(++count)+"轮"+Arrays.toString(arr));
			}
		}
	}
	
	
	
	// 插入排序
	public static void insertSort(int[] arr) {
		int insertVal = 0;//定义一个临时变量用于保存要插入的数
		int insertIndex = 0;//下标
		
		// 因为插入排序第一个是有序表中的数 所以下标从1开始
		for (int i = 1; i < arr.length; i++) {
			//定义待插入的数
			insertVal = arr[i];//从第二个数开始 保存要插入的值
			insertIndex = i-1;//前一个数的下标
			
			while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];//把大的那份值 复制一份到它的后面
				insertIndex--;
			}
			if(insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertVal;
			}
			System.out.println("第"+i+"轮插入");
			System.out.println(Arrays.toString(arr));
		}
	}
	
	
	// 选择排序
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = arr[i];//假定第一个数为最小
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {//从第二个数开始与min做比较
				if(arr[j] < min) {//找到最小值并交换数据
					min = arr[j];
					minIndex = j;
				}
			}
			//将找到的最小值放到前面 交换位置
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}
	
	
	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		int temp = 0;// 交换变量
		boolean flag = false;//判断是否进行了交换 true 则有
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i ; j++) {
				if(arr[j] > arr[j + 1]) {
					flag = true;
					temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
			if(!flag) {
				break;
			}else {
				flag = false;
			}
		}
	}
}
