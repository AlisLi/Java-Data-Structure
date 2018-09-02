package cn.lzg.algo.bubbleSort;

import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * 冒泡排序
 */
public class BubbleSort {

    private BubbleSort(){}

    public static void sort(Comparable[] arr){

        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - i - 1;j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr,j,j + 1);
                }
            }
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
        SortTestHelper.testSort("cn.lzg.algo.bubbleSort.BubbleSort", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
