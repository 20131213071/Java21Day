package basic;

/**
 * Created by smx on 2017/8/14.
 */
public class CommonSort {

    /*
    * 冒泡排序
    * */
    public void bubbleSort(){

    }

    /*
    * 选择排序
    * */
    public void selectSort(){

    }
    /*
    * 归并排序
    * */
    public void mergerSort(){

    }

    /*
    * 快速排序
    * */
    public void fastSort(){

    }

    /*
    * 插入排序
    * */
    public void insertSort(){

    }

    /*
    * 二分排序递归实现
    * */
    public int binaryOrding(int[] array,int start ,int end, int key){
        int mid = (end - start)/2+start;
        if (array[mid] == key){
            return mid;
        }
        if (start > end){
            return -1;
        }
        if (start == end){
            if (array[start] == key){
                return start;
            }else
                return -1;
        }
        if (start < end){
            if (key < array[mid]){
                return  binaryOrding(array,start,mid-1,key);
            }else {
                return binaryOrding(array,mid+1,end,key);//mid+1不是array[mid]+1!!
            }
        }
        return  -1;
    }
    /*
    * 二分遍历
    * */
    public int binaryFind(int[] array,int key){
        int mid = array.length/2;
        if (key == array[mid]){
            return mid;
        }
        int start = 0;
        int end = array.length-1;
        while (start < end){
            mid = (end -start)/2+start;
            if (key < array[mid]){
                end = mid -1 ;
            }else if (key > array[mid]) {
                start = mid +1 ;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        CommonSort commonSort = new CommonSort();
        int[] array= {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        //System.out.println(commonSort.binaryOrding(array,0,array.length-1,3));
        System.out.println(commonSort.binaryFind(array,5));
    }
}
