package sort;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1};
		insertSort(arr);
		
	}

	// 插入排序
	public static void insertSort(int[] arr) {
		int insertVal = 0;//定义一个临时变量用于保存要插入的数
		int insertIndex = 0;//下标
		// 使用for循环来把代码简化
		// 因为插入排序 第一个数是有序表中的数 所以下标从1开始
		for (int i = 1; i < arr.length; i++) {
			//定义待插入的数
			insertVal = arr[i];//从第二个数开始
			insertIndex = i - 1; // 即arr[1]的前面这个数的下标
	
			// 给insertVal 找到插入的位置
			// 说明
			// 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
			// 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
			// 3. 就需要将 arr[insertIndex] 后移
			while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
				arr[insertIndex + 1] = arr[insertIndex];
				insertIndex--;
			}
			// 当退出while循环时，说明插入的位置找到, insertIndex + 1
			// 举例：理解不了，我们一会 debug
			//这里我们判断是否需要赋值
			if(insertIndex + 1 != i) {
				arr[insertIndex + 1] = insertVal;
			}
	
			System.out.println("第"+i+"轮插入");
			System.out.println(Arrays.toString(arr));
		}
		
		
		/*
		//使用逐步推导的方式来讲解，便利理解
		//第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}
				
		//{101, 34, 119, 1}; => {101,101,119,1}
		//定义待插入的数
		int insertVal = arr[1]; //保存要插入的值
		int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标
				
		//给insertVal 找到插入的位置
		//说明
		//1. insertIndex >= 0 保证在给insertVal 保存要插入的值
		//2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
		//3. 就需要将 arr[insertIndex] 后移
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {
			arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
			insertIndex--;
		}
		//当退出while循环时，说明插入的位置找到, insertIndex + 1
		arr[insertIndex + 1] = insertVal;
				
		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));
				
		//第2轮
		insertVal = arr[2];//保存要插入的值
		insertIndex = 2 - 1; //前一个数的下标
				
		while(insertIndex >= 0 && insertVal < arr[insertIndex] ) {//要插入的数小于前一个数就进去，大于则不变
			arr[insertIndex + 1] = arr[insertIndex];//如果大了，就把大的那份值复制一份到后面（会覆盖后面的值）
			insertIndex--;
		}
				
		arr[insertIndex + 1] = insertVal; //把小的数放前面
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));
		*/
	}
}
