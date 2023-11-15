package hashtab;

public class HashTabDemo {

	public static void main(String[] args) {
		
	}

	// 表示一个雇员
	class Emp {
		public int id;
		public String name;
		public Emp next;
		public Emp(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
	}
	
	//创建EmpLinkedList，表示链表
	class EmpLinkedList{
		// 头指针，指向第一个Emp，因此我们这个链表的head 是指向第一个Emp
		private Emp head;//默认null
		
		//添加雇员到链表
		//说明
		//1.假定，当添加雇员时，id是自增长
		//	因此我们将该雇员直接加入到本链表的最后即可
		public void add(Emp emp) {
			//如果是添加第一个雇员
			if(head == null) {
				head = emp;
				return;
			}
			//如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
			Emp curEmp = head;
			while(true) {
				if(curEmp.next == null) {//说明到链表最后
					break;
				}
				curEmp = curEmp.next;//后移
			}
			//退出时直接将emp 加入链表
			curEmp.next = emp;
		}
		
		//遍历链表的雇员信息
		public void list() {
			if(head == null) { //说明链表为空
				System.out.println("当前链表为空");
				return;
			}
			System.out.println("当前链表的信息为");
			Emp curEmp = head;//辅助指针
			while(true) {
				System.out.printf("=> id=%d name=%s\t",curEmp.id, curEmp.name);
			}
		}
	}
}
