package java21Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	//list基本操作
	public void listAction(){
		ArrayList<String> list = new ArrayList<String>();
		//add get
		list.add("a");
		list.set(0, "b");
		String s = list.get(0);
	
		int len = list.size();
		boolean c = list.contains("b");
		
		List<String> lists = new ArrayList<String>();
		//lists和list的并集
		lists.addAll(list);
	}
	//list循环
	public void loopList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);list.add(1);list.add(2);
		for(int i= 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		for(Integer i : list){
			System.out.println(i);
		}
	}
	
	//list删除
	public void removeList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);list.add(1);list.add(2);
		//remove有两种形式，一种是int index，一种按照list中具体复合类型值来删除
		//api说明中强调了，在remove(Object o)时，是删除第一次出现的这个值。
		list.remove(1);
		list.remove(2);
		//list和ll的差集  list.removeall(ll);
	}
	
	//删除重复且保留了最后一个相同的字母
	public void loopremoveList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);list.add(3);list.add(2);list.add(2);list.add(1);list.add(2);
		for(int i= 0;i<list.size();i++){
			if(list.get(i).equals(2)){
				list.remove(2);
			}
		}
		System.out.println(list);//输出[3,1,2]每次删除size就在变化，导致数组没有循环到最后一个重复数字。
	}
	//使用iterator删除重复元素
	public void iteratorRemoveList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);list.add(3);list.add(2);list.add(2);list.add(1);list.add(2);
		/*iterator()方法是java.lang.Iterable接口，被collection继承。
		iterator()要求容器返回一个迭代器，
		第一次调用it.next()返回序列的第一个元素，之后返回下一个
		hasNext()检查是否含有元素，remove()迭代器新返回的元素删除
		*/
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			if(it.next().equals(2)){
				it.remove();
			}
		}
	}
	
	//数组转List
	public void arrayToList(){
		Integer[] i = new Integer[]{1,2,3};
		List<Integer> array = Arrays.asList(i);//返回特殊的数组不是真正的list，不能增删元素
		List<Integer> list = new ArrayList<Integer>(array);
	}
	//list排序
	public void sortList(){
		List<String> list = new ArrayList<String>();
		list.add("a");list.add("b");list.add("d");
		Collections.sort(list);//默认升序排列
		//collection<T>接口和collections是继承于object的类
		//collections类是由在collection接口进行操作或返回的静态方法组成
	}
	public void sortListDesc(){

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		l1.add(1);l2.add(2);l3.add(3);l3.add(4);
		list.add(l1);list.add(l2);list.add(l3);
		//修改默认顺序
		Collections.sort(list, new Comparator<List<Integer>>(){ 
			public int compare(List<Integer> o1,List<Integer> o2){
			//假如A的值大于B，你返回1。这样调用Collections.sort()方法就是升序
			//假如A的值大于B，你返回-1。这样调用Collections.sort()方法就是降序
				if(o1.get(0)>o2.get(0)){//desc
					return -1;
				}else if (o1.get(0)<o2.get(0)){
					return 1;
				}else
				return 0;
			
		}
	});
		System.out.println(list);//输出[[3, 4],[2], [1] ]
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
