package java21Day;

public class MySort {
	public static void main(String args[]){
		int[] array={13,41,22,15,63,53};
		MySort mySort = new MySort();
		mySort.bubbleSort(array);
		mySort.quickSort(array);
		for(int j:array)
			System.out.print(j+" ");
	}
	
	/** 
	 * @MethodName: bubbleSort 
	 * @Description: 冒泡排序,相邻元素两两比较
	 * @Parameter: @param array
	 * @return void
	 * @Example: TODO
	 * @ModificationHistory: 
	 * Author		Date		Description(Why & What is modified)
	 * -----------------------------------------------------------------------------------
	 * smx - 2017年2月9日 上午10:43:37 - First Release
	 * 
	 */
	public void bubbleSort(int[] array){
		int temp=0;
		for(int i=0;i<array.length-1;i++){//比较趟数
			for(int j=i;j<array.length-1;j++){//比较相邻比较次数
				if(array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		
	}
	//快速排序
	public void quickSort(int[] array){
		
	}
}
