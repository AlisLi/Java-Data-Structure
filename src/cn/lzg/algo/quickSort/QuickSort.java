package cn.lzg.algo.quickSort;

import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * @author lzg
 * @date 2018/9/3 9:22
 * @desc 快速排序
 */
public class QuickSort {

    private QuickSort(){}

    //对arr[l...r]进行partition操作
    //返回p，使得arr[l...p-1] < arr[p],arr[p] < arr[p + 1...r]
    public static int partition(Comparable[] arr,int l,int r) {

        Comparable v = arr[l];

        int i = l;
        for(int j = l + 1;j <= r;j++){
            if(arr[j].compareTo(v) < 0){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i,l);

        return i;
    }

    public static void sort(Comparable[] arr,int l,int r){

        if(r <= l){
            return;
        }

        int p = partition(arr,l,r);
        sort(arr,l,p - 1);
        sort(arr,p + 1,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n - 1);
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
        SortTestHelper.testSort("cn.lzg.algo.quickSort.QuickSort", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
