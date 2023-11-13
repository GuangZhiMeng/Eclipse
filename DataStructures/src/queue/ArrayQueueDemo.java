package queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		// 测试
		// 创建一个队列
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' '; // 接受用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		// 输出一个菜单
		while(loop) {
			System.out.println("s(show)：显示队列");
			System.out.println("e(exit)：退出程序");
			System.out.println("a(add)：添加数据到队列");
			System.out.println("g(get)：从队列取出数据");
			System.out.println("h(head)：查看队列头的数据");
			key = scanner.next().charAt(0); // 接受一个字符
			switch (key) {
			case 's': // 显示队列
				queue.showQueue();
				break;
			case 'a': // 添加数据到队列
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g': // 从队列取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出程序
				scanner.close(); // 关闭输入
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序已经退出");
	}
	
}

// 使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
	 private int maxSize; // 表示数组的最大容量
	 private int front; // 队列头
	 private int rear; // 队列尾
	 private int[] arr; // 该数组用与存放数据，模拟队列
	 
	 // 创建队列的构造器
	 public ArrayQueue(int arrMaxSize) {
		 maxSize = arrMaxSize;
		 arr = new int[maxSize];
		 front = -1; // 指向队列头部第一个数的前一个位置
		 rear = -1; // 指向队列末尾部的数据（即队列的最后一个数据）
	 }
	 
	 // 判断队列是否满
	 public boolean isFull() {
		 return rear == maxSize - 1;
	 }
	 
	 // 判断队列是否为空(图例上有)
	 public boolean isEmpty() {
		 return rear == front;
	 }
	 
	 // 添加数据到队列
	 public void addQueue(int n) {
		 // 判断队列是否满
		 if(isFull()) {
			 System.out.println("队列满，不能加入数据");
			 return;
		 }
		 rear++; // 让rear 后移
		 arr[rear] = n;
	 }
	 
	 // 获取队列的数据，出队列
	 public int getQueue() {
		 // 判断队列是否为空
		 if(isEmpty()) {
			 // 通过抛出异常
			 throw new RuntimeException("队列空，不能取数据");
		 }
		 front++; // front 后移
		 return arr[front];
	 }
	 
	 // 显示队列的所有数据
	 public void showQueue() {
		 // 遍历数组
		 if(isEmpty()) {
			 System.out.println("队列空的，没有数据");
			 return;
		 }
		 for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n",i,arr[i]);
		}
	 }
	 
	 // 显示队列的头数据，注意不是取出数据
	 public int headQueue() {
		 // 判断
		 if(isEmpty()) {
			 throw new RuntimeException("队列空的，没有数据");
		 }
		 // front最初 = -1; 它指向队列头部第一个数的前一个位置，所以是front + 1
		 return arr[front + 1];
	 }
}
