package java21Day;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//常用方法
public class MapDemo {
	public void mapAction(){
		Map<String,String> map = new HashMap<String,String>();
		//put get
		map.put("a", "this is");
		map.get("a");
		int len = map.size();
		System.out.println(len);
		map.containsKey("a");
		map.containsValue("this is");
		//map.putAll(m1);取并集

	}
//循环取key和value
public void loopmap(){
	Map<String,Integer> map =new HashMap<String,Integer>();
	map.put("a",3);map.put("a",3);
	
	//keySet是个Set<T>类型
	Set<String> s = map.keySet();
	for(String i :s){//String类型的key
		System.out.println(map.get(i));//得值
	}
	
	//value是一个Collection<T>类型
	Collection<Integer> v = map.values();//得值
	for(Integer j :v){//Integer类型的value
		System.out.println(j);
	}
	for(String j :map.keySet()){
		map.get(j);
		map.values();
		map.put(j, map.get(j));
	}
}	
//key和value的删除
public void removeMap(){
	Map<String, String> map = new HashMap<String, String>();
	map.put("a", "this is a");
	map.put("b", "this is b");
	map.remove("a");//键值一起删除
}
//循环删除
public void loopremoveMap(){
	Map<Integer, String> map = new HashMap<Integer, String>();
	map.put(1, "this is a");
	map.put(2, "this is b");
	/**
	*set虽然可以看作一个特殊的list,但是set没有像list一个通过get取值的方式
	*要想取值，可以将set转为List，或者转为iterator
	*/
	Set<Integer> set = map.keySet();
	List<Integer> list = new ArrayList<Integer>(set);
	for(int i = 0 ;i<list.size();i++){
		map.remove(list.get(i));
	}
	for(Integer i :set){
		map.remove(i);
	}
	
	//清除所有的键值对
	map.clear();
	boolean e = map.isEmpty();
}
//按照key排序
public void sortByKey(){
	Map<String, String> map = new HashMap<String, String>();
	map.put("a", "this is a");
	map.put("c", "this is c");
	map.put("b", "this is b");
/*	TreeMap是一个按key进行升序排列的一个Map实现类
	TreeMap会自动的把里面的键值对进行排序*/
	Map<String,String> treemap = new  TreeMap<String,String>();
	treemap.putAll(map);
	
/**
	* LinkedHashMap是会记录你put进去的顺序，输出时，会按你put进去的顺序进行
	输出
	* 利用这一点，将HashMap的key按要求排列好，然后再put进一个LinkedHashMap
	即能实现map的复杂排序
*/
	Map<String,String> mp = new LinkedHashMap<String,String>();
	List<String> key = new ArrayList<String>(mp.keySet());
	Collections.sort(key, new Comparator<String>(){
		public int compare(String o1,String o2){
			return o1.compareTo(o2);//o1>o2 返回1 升序
			//return o2.compareTo(o1);o1>o2返回-1降序
		}
	});
	for(String key0:key){
		mp.put(key0, map.get(key0));
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
