package basic;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/21.
 */
public class ALG {
    /*五只猴子分桃子,第一只扔掉一只桃子,正好分成五份,第一只..第三只第四.第五都是如此,问:一共有多少桃子?
      注意:答案3121个,寻求方法!
    * */
    private static int sum() {
        int m=0,x=1,i=0;
        while (true) {
            m=x;
            for (i = 0; i < 5; i++) {//5只猴子，迭代五次
                if ((m - 1) % 5 == 0) {
                    m = (m - 1) / 5 * 4;
                } else {
                    break;
                }
            }
            if (i == 5 && m > 0) {//if在这里是为了结束while循环
                break;
            }
            x++;
        }
    return x;//如果返回m，m=x时候是所要3121，for之后m变为1020
    }
    /*
    * 完数，个小于它的约数（真约数,列出某数的约数，去掉该数本身，剩下的就是它的真约数）的和等于它本身的自然数叫做完全数（Perfect number）
    * 1+2+3=6；1+2+4+7+14=28；第三个完全数是496
    * */
    private static void perfectNum(int num){
        int sum=0;
        ArrayList<Integer> arrayList = new ArrayList<>();

        //获取公约数并放入列表内
        for ( int j=1;j<=num;j++ ){
            if(num%j==0){
                arrayList.add(j);
            }
        }
        for (int k=0;k<arrayList.size();k++){
             sum += arrayList.get(k);
            if (num==(sum-num)){
                for (int m=0;m<arrayList.size()-1;m++){
                    System.out.println(arrayList.get(m));
                }
            }
        }
    }
    /*
    * 价值最大化;01背包问题：一个背包总容量为V，现在有N个物品，第i个 物品体积为weight[i]，价值为value[i]，现在往背包里面装东西，怎么装能使背包的内物品价值最大？
    * http://blog.csdn.net/sj13051180/article/details/6687674 算法分析思路
    * */
    private static void zeroOnePackage(int N,Float V, ArrayList<Float> c ,ArrayList<Float> w){

        ArrayList<Float> o = new ArrayList<>();
            for (int i=0;i<N;i++){
                //


                float a = c.get(i)-w.get(i);
                o.add(a);
            }
    }
    public static void main(String[] args) {
        //System.out.println(sum());
        //ALG.perfectNum(28);//1 2 4 7 14
    }
}


