package linkedlist;

public class josephu {

	public static void main(String[] args) {
		// 测试一把看看构建环形链表，和遍历是否ok
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
		circleSingleLinkedList.showBoy();
		
		//测试一把小孩出圈是否正确
		circleSingleLinkedList.countBoy(10, 20, 125); // 2->4->1->5->3
		//String str = "7*2*2-5+1-5+3-3";
	}

}

// 创建一个Boy类，表示节点
class Boy{
	private int no;// 编号
	private Boy nextBoy;//指向下一个节点，默认null
	public Boy(int no) {
		this.no = no;
	}
	
	// 快速生成get和set方法：右击——》Source——》Generate Getters and Setters……
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNextBoy() {
		return nextBoy;
	}
	public void setNextBoy(Boy nextBoy) {
		this.nextBoy = nextBoy;
	}
	
}


// 创建一个环形的单向链表
class CircleSingleLinkedList{
	// 创建一个first节点，当前没有编号
	private Boy firstBoy = new Boy(-1);
	// 添加新的节点，构建成一个环形链表
	public void addBoy(int nums) {
		//nums 做一个数据校验
		if(nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null; // 定义一个辅助指针，帮助构建环形链表
		//使用for来创建我们的环形链表
		for (int i = 0; i < nums; i++) {
			//根据编号，创建节点
			Boy boy = new Boy(i);
			// 如果是第一个节点
			if(i == 1) {
				firstBoy = boy;
				firstBoy.setNextBoy(firstBoy);
				curBoy = firstBoy; // 让curBoy指向第一个节点
			} else {
				curBoy.setNextBoy(boy);
				boy.setNextBoy(firstBoy);
				curBoy = boy;
			}
		}
	}
	
	
	// 遍历当前的环形链表
		public void showBoy() {
			// 判断链表是否为空
			if (firstBoy == null) {
				System.out.println("没有任何小孩~~");
				return;
			}
			// 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
			Boy curBoy = firstBoy;
			while (true) {
				System.out.printf("小孩的编号 %d \n", curBoy.getNo());
				if (curBoy.getNextBoy() == firstBoy) {// 说明已经遍历完毕
					break;
				}
				curBoy = curBoy.getNextBoy(); // curBoy后移
			}
		}
		
		
		
		// 根据用户的输入，计算出小孩出圈的顺序
		/**
		 * 
		 * @param startNo
		 *            表示从第几个小孩开始数数
		 * @param countNum
		 *            表示数几下
		 * @param nums
		 *            表示最初有多少小孩在圈中
		 */
		public void countBoy(int startNo, int countNum, int nums) {
			// 先对数据进行校验
			if (firstBoy == null || startNo < 1 || startNo > nums) {
				System.out.println("参数输入有误， 请重新输入");
				return;
			}
			// 创建要给辅助指针,帮助完成小孩出圈
			Boy helper = firstBoy;
			// 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
			while (true) {
				if (helper.getNextBoy() == firstBoy) { // 说明helper指向最后小孩节点
					break;
				}
				helper = helper.getNextBoy();
			}
			
			//小孩报数前，先让 first 和  helper 移动 k - 1次
			for(int j = 0; j < startNo - 1; j++) {
				firstBoy = firstBoy.getNextBoy();
				helper = helper.getNextBoy();
			}
			
			//当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
			//这里是一个循环操作，知道圈中只有一个节点
			while(true) {
				if(helper == firstBoy) { //说明圈中只有一个节点
					break;
				}
				//让 first 和 helper 指针同时 的移动 countNum - 1
				for(int j = 0; j < countNum - 1; j++) {
					firstBoy = firstBoy.getNextBoy();
					helper = helper.getNextBoy();
				}
				//这时first指向的节点，就是要出圈的小孩节点
				System.out.printf("小孩%d出圈\n", firstBoy.getNo());
				//这时将first指向的小孩节点出圈
				firstBoy = firstBoy.getNextBoy();
				helper.setNextBoy(firstBoy); //
				
			}
			System.out.printf("最后留在圈中的小孩编号%d \n", firstBoy.getNo());
		}
}

