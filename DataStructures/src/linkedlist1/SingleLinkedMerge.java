package linkedlist1;

public class SingleLinkedMerge {
	
	public static void main(String[] args) {
		// 创建节点
		Node node1 = new Node(1, "大娃");
		Node node2 = new Node(2, "二娃");
		Node node3 = new Node(3, "三娃");
		Node node4 = new Node(4, "四娃");
		Node node5 = new Node(5, "五娃");
		Node node6 = new Node(6, "六娃");
		Node node7 = new Node(7, "七娃");
		Node node8 = new Node(8, "葫芦小金刚");
		
		// 创建链表
		SingleLinkedList singleLinkedList1 = new SingleLinkedList();
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		SingleLinkedList singleLinkedList3 = new SingleLinkedList();
		
		// 添加节点
		singleLinkedList1.addByOrder(node1);
		singleLinkedList1.addByOrder(node3);
		singleLinkedList1.addByOrder(node6);
		singleLinkedList1.addByOrder(node7);
		singleLinkedList2.addByOrder(node2);
		singleLinkedList2.addByOrder(node4);
		singleLinkedList2.addByOrder(node5);
		singleLinkedList2.addByOrder(node8);
		
		// 显示两个链表
		System.out.println("单链表1：");
		singleLinkedList1.list();
		System.out.println("单链表2：");
		singleLinkedList2.list();
		
		// 显示合并后的链表
		twoLinkedList(singleLinkedList1.getHead(), singleLinkedList2.getHead(), singleLinkedList3.getHead());
		System.out.println("组合后的链表：");
		singleLinkedList3.list();
	}
	
	// twoLinkedList方法
	// 传入待合并的两个链表的头节点以及第三个单链表的头节点
	public static void twoLinkedList(Node head1, Node head2, Node head3) {
		// 如果两个链表均为空，则无需合并，直接返回
		if(head1.next == null && head2.next == null) {
			return;
		}
		// 如果链表1为空，则将head3.next指向head2.next，实现链表2中的节点连接到链表3
		if(head1.next == null) {
			head3.next = head2.next;
		} else {
			// 将head3.next指向head1.next，实现链表1中的节点连接到链表3
			head3.next = head1.next;
			// 定义一个辅助的指针（变量），帮助我们遍历链表2
			Node cur2 = head2.next;
			// 定义一个辅助的指针（变量），帮助我们遍历链表3
			Node cur3 = head3;
			Node next = null;
			// 遍历链表2，将其节点按顺序连接至链表3
			while(cur2 != null) {
				// 链表3遍历完毕后，可以直接将链表2剩下的节点连接至链表3的末尾
				if(cur3.next == null) {
					cur3.next = cur2;
					break;
				}
				// 在链表3中，找到第一个大于链表2中的节点编号的节点
				// 因为是单链表，找到的节点是位于添加位置的前一个节点，否则无法插入
				if(cur2.no <= cur3.next.no) {
					next = cur2.next;  // 先暂时保存链表2中当前节点的下一个节点，方便后续使用
					cur2.next = cur3.next;  // 将cur2的下一个节点指向cur3的下一个节点
					cur3.next = cur2;  // 将cur2连接到链表3上
					cur2 = next;  // 让cur2后移
				}
				// 遍历链表3
				cur3 = cur3.next;
			}
		}
	}
}

// 定义SingleLinkedList类管理节点
class SingleLinkedList {
	// 先初始化头节点，头节点不动
	private Node head = new Node(0, "");
	
	// 获取链表的头节点
	public Node getHead() {
		return head;
	}
	
	// 添加节点时，根据编号按顺序将节点插入到指定位置
	// 如果链表中已有这个编号，则添加失败，并给出提示
	public void addByOrder(Node Node) {
		// 头节点不能动，通过一个辅助指针（变量）帮助找到需要添加的位置
		// 因为是单链表，找到的temp是位于添加位置的前一个节点，否则无法插入
		Node temp = head;
		boolean flag = false;	// flag标志添加的编号是否存在，默认为false
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > Node.no) {
				break;
			}
			if(temp.next.no == Node.no) {
				flag = true;
				break;
			}
			temp = temp.next;	// 遍历链表
		}
		if(flag) {
			System.out.printf("输入的编号%d已经存在,不能加入\n", Node.no);
		}
		else {
			Node.next = temp.next; 
			temp.next = Node;
		}
	}
	
	// 显示链表【遍历】
	public void list() {
		// 判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点不能动，需要一个辅助变量来遍历
		Node temp = head.next;
		while (true) {
			// 判断是否到链表最后
			if(temp == null)
				break;
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移
			temp = temp.next;
		}
	}
}

// Node类，每个Node对象就是一个节点
class Node {
	public int no;
	public String name;
	public Node next;	// 指向下一个节点
	
	// 构造器
	public Node(int no, String name) {
		this.no = no;
		this.name = name;
	}
	// 为了显示方便，重新toString
	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + "]";
	}
}
