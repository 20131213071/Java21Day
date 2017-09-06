package basic;

import org.apache.poi.util.SystemOutLogger;

import java.util.*;

/**
 * @author Administrator
 *
 */
public class ListNode {
	  //头节点
	  public Node head;
	  public Node current;
	  
	  /**
	 * 定义Node内部类
	 *
	 */

	class Node{
		  Node next =null;//指针域
		  int data;//数据域
		  public Node(int data){
			  this.data=data;
			  }
		  }

	  /**
	 * 向链表中插入数据
	 */
	  public void addNode(int data){
		  Node node = new Node(data);
		  if(head == null){//判断链表为空的时候//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头
			  head = node;
			  current = head;
		  }else{
		  	//current.next指向node
			  current.next = node;//创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
			  // current.next对象赋值给current对象，变成current对象
			   current = current.next;//把链表的当前索引向后移动一位,此步操作完成之后，current结点指向新添加的那个结点
		  }
	  }


	/**
	 * 遍历列表
	 * @param //从node这个节点开始遍历列表
	 */
	public void displayNode(Node node){
		if(node == null){
			return;
		}
		current = node;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	/**
	 * 获取单链表的长度
	 */
	public int getLen(){
		if(head == null){
			return 0;
		}
		int len = 0;
		current = head;
		while(current != null){
			current = current.next;
			len++;
		}
		return len;
	}


	  /**
	   * 递归逆序输出链表
	   * 注意返回为ArrayList时候，定义必须放在迭代的外面，不然只会返回一个值[58,24,0,67]返回[67]
	   */

	  ArrayList<Integer> list = new ArrayList<Integer>();
	  public ArrayList<Integer> reversePrint(Node head){
		  //ArrayList<Integer> list = new ArrayList<Integer>();
		  if(head != null ){
			  reversePrint(head.next);
			  list.add(head.data);
		  }else{
			  return list;
		  }
		  return list;
	  }
	
	/**
	 * 自己创建栈来达到，先进后出，逆序打印的效果
	 */
	public void reversePrintByStack(Node head){
		if(head == null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		current = head;
		while(current != null){
			stack.push(current);
			current = current.next;
		}
		while(stack.size()>0){
			int data = stack.pop().data;
			System.out.println(data);
		}
	}
	/*
	* 反转单列表，遍历实现
	* */
	public Node reverseSignalNode(Node node){
		if(node == null){
			return node;
		}
		Node reverseHead = null;
		Node next = null;
		current = head;
		if(current != null){
			next = current.next;

			current.next = reverseHead;
			reverseHead = current;//current 对象赋值给reverseHead对象，是的current.next指针指向current对象，指针反转

			current = next;
		}
		return reverseHead;
	}

	/*
	* 反转单列表，递归输出，反转的是指针
	* */
	public Node reverseNode1(Node head){
		//如果链表为空或者链表中只有一个元素
		if(head == null || head.next == null){
			return head;
		}
		Node reverseNode = null;
		//先反转后面的链表，走到链表的末端结点
		reverseNode = reverseNode1(head.next);//head和head.next对象不为空，即倒数二和一对象，指针为head.next/head.next.next
		//再将当前节点设置为后面节点的后续节点
		head.next.next = head; //head.next.next指向到head不是reverseNode
		head.next = null;//head.next置null，让head下次迭代输出往倒数第三个走

		return reverseNode;
	}

	/*
	* 查找链表中倒数第K个节点的值
	* */
	public int findNode1(int index){
		if(index == 0 ) {
			return head.data;
		}
		if(head == null){
			return -1;
		}
		current = head;
		int len = 0 ;
		while (current != null){
			current = current.next;
			len++;
		}
		//一定要重置current为head，不然上面while已经将current置位null了，下面会报NullPointExcption!!
		current = head;

		if(len < index){
			return  -1; //这个一定要考虑进去，index比给出的链表长度长时候，返回[]
		}
		for (int i = 0 ; i < len - index ; i++){
			current = current.next;
		}
		return current.data;
	}


	  public Node findNode(Node head,int index){
		  if(head == null){
			  return head;
		  }
		  current = head;
		  int len = 0 ;
		  while (current != null){
			  current = current.next;
			  len++;
		  }
		  current = head;
		  if(len < index ){
		  	return null;
		  }
		  for (int i = 0 ; i < len - index ; i++){
			  current = current.next;
		  }
		  return current;
	  }

	/*
	* 删除链表中重复的元素
	* */
	public Node deleNode(Node head){
		Node newNode = null;
		if (head == null) {
			return null;
		}else if(head.next == null){
			return head;
		}else{
			current = head;
			while (current != null){
				if (current.data != current.next.data){
					newNode = current;
					current = current.next;
					current.next = current.next.next;
				}else {
					current.next = current.next.next;
					newNode = current.next;

				}
			}
		}
		return  newNode;
	}
	/*
	* 时间复杂度O(n)
	* */
	public void deleByHashTable(Node head){
		Hashtable<Integer,Integer> table =  new Hashtable<Integer,Integer>();
		current = head;
		Node tmp = null;
		while (current != null){
			if (table.containsKey(current.data)){
				tmp.next = current.next;
			}else {
				table.put(current.data,1);
				tmp = current;
			}
			current = current.next;
		}
	}
	public void deleByTwoNode(Node head){
		current = head;
		Node newNode = null;
		while (current != null){
			newNode = current;
			if(newNode.next.data == current.data){
				newNode.next = newNode.next.next;
			}else {
				newNode = newNode.next;
			}
			current = current.next;
		}
	}










	public static void main(String[] args) {
		ListNode listn = new ListNode();
		listn.addNode(112);
		listn.addNode(2);
		listn.addNode(1);
		listn.addNode(1);
		listn.addNode(5);

/*		int i = listn.findNode(listn.head,6).data;
		System.out.println(i);*/
//		System.out.println(listn.findNode(listn.head,6));
/*		ArrayList<Integer> list = new ArrayList<>();
		 list = listn.reversePrint(listn.head);
		for(int i=0 ; i < list.size() ;i++){
			System.out.println(list.get(i));
		}*/


	}

	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	

