package recursion;

import linkedlist.TestStack;

public class RecursionTest {

	public static void main(String[] args) {
		//通过打印问题，回顾递归的调用机制
		test(4);
	}
	
	public static void test(int n) {
		if(n > 2) {
			test(n - 1);
		}
		/*	加入else 结果为：n = 2	*/
		System.out.println("n=" + n);
	}

	// 运行结果
//	n=2
//	n=3
//	n=4
}
