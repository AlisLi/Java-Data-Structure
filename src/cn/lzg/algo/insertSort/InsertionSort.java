package cn.lzg.algo.insertSort;

import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * 插入排序
 * 升序
 */
public class InsertionSort {

    // 我们的算法类不允许产生任何实例
    private InsertionSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;


        for(int i = 0;i < n;i++){
            //写法1
//            for(int j = i;j > 0;j--){
//                //从后向前依次比较，找到合适位置插入
//                if(arr[j].compareTo(arr[j - 1]) < 0){
//                    swap(arr,j,j-1);
//                }else{
//                    break;
//                }
//            }
            // 写法2
//          for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
//              swap(arr, j, j-1);

            // 写法3
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }

    /**
     * 通过下标交换数组中的两个值
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(Object[] arr,int i,int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(){
        Integer[] arr = {10,9,8,5,7,6,4,3,2,1};
        sort(arr);
        for (int i = 0;i < arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void testTime(){
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("cn.lzg.algo.insertSort.InsertionSort", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
