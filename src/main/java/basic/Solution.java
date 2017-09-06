package basic;

import java.util.ArrayList;

public class Solution {
    public boolean Find(int target, int[][] b) {
    	boolean flag=false;
    	for (int w = 0; w < b.length; w++) { // 二维数组的长度  
            for (int t = 0; t < b[w].length; t++) { // 一维数组的长度  
            	int j = t+1;
                for (int i = w; i < b.length; i++) { // 二维数组的长度  
                    for (; j < b[w].length; j++) { // 一维数组的长度  
                        if (b[w][t] > b[i][j]) { // 套在for循环里，俩个一模一样的数组进行比较  
                            int max = 0;  
                            max = b[i][j];  
                            b[i][j] = b[w][t];  
                            b[w][t] = max;  
                        }
                    }  
                    j=0;
                }  
            } 
    	}
    	for (int w = 0; w < b.length; w++) { // 二维数组的长度  
            for (int t = 0; t < b[w].length; t++) { // 一维数组的长度  
                if(target == b[w][t])
                	flag=true;
                System.out.println(b[w][t]+" ");
            }
        }
        return flag;
    }
    public String replaceSpace(StringBuffer str) {
    	String string = str.toString().replace(" ","%20");;//StringBuffer转换为String
    	//String string = new String(str);
    	return string;
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        return list;
        
    }
    
    public static void main(String args[]){
        Solution solution = new Solution();
        //二位数组全排序
        int [][] array = {{1,2,8,9},{2,4,9,12},{6,8,11,15}};
        boolean result = solution.Find(15,array);
        if(result == true){
            System.out.println("is");
        }else{
            System.out.println("eroe");
        }
        
        //字符串替换：请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
        StringBuffer str = new StringBuffer ("We Are Happy");//字符串转换为StringBuffer
        String sys = solution.replaceSpace(str);
        System.out.println(sys);
        
        //链表打印：输入一个链表，从尾到头打印链表每个节点的值。
        
        
    }
}
