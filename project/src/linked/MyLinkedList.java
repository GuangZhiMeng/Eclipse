package linked;

import java.util.LinkedList;

import javax.xml.soap.Node;

public class MyLinkedList {

    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;

    /**
     * 链表插入元素
     * @param index  插入位置
     * @param data  插入元素
     */
    public void insert(int index, int data) throws Exception {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node insertedNode = new Node(data);
        if(size == 0){
            //空链表
            head = insertedNode;
            last = insertedNode;           
        } else if(index == 0){
            //插入头部
        	//1、把新节点的next指针指向原先的头节点
            insertedNode.next = head;
            //2、把新节点变为链表的头节点
            head = insertedNode;
        }else if(size == index){
            //插入尾部
        	//把最后一个节点的next指针指向新插入的节点
            last.next = insertedNode;
            last = insertedNode;
        }else {
            //插入中间
        	//1、新节点的next指针，指向插入位置的节点
            Node prevNode = get(index-1);
            insertedNode.next = prevNode.next;
            //2、插入位置前置节点的next指针，指向新节点
            prevNode.next = insertedNode;
        }
        size++;
    }

    /**
     * 链表删除元素
     * @param index  删除的位置
     */
    public Node remove(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node removedNode = null;
        if(index == 0){
            //删除头节点
        	//把链表的头节点设为原先头节点的next指针即可
            removedNode = head;
            head = head.next;
            if(size == 1){
                last = null;
            }
        }else if(index == size-1){
            //删除尾节点
        	//把倒数第二个节点的next指针指向空即可
            Node prevNode = get(index-1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }else {
            //删除中间节点
        	//把要删除节点的前置节点的next指针，指向要删除元素的一个节点即可
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 链表查找元素
     * @param index  查找的位置
     */
    public Node get(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        //1、将查找的指针定位到头节点
        Node temp = head;
        //2、根据头节点指针，定位到下一个节点
        for(int i=0; i<index; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output(){
        Node temp = head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0,3);
        myLinkedList.insert(0,4);
        myLinkedList.insert(2,9);
        myLinkedList.insert(3,5);
        myLinkedList.insert(1,6);
        myLinkedList.remove(0);
        myLinkedList.output();
    }
}