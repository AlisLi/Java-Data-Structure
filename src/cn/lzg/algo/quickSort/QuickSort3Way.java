package cn.lzg.algo.quickSort;

import cn.lzg.algo.insertSort.InsertionSort;
import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * @author lzg
 * @date 2018/9/3 14:03
 * @desc 三路的快速排序
 * 三路快速排序算法也是一个O(nlogn)复杂度的算法
 */
public class QuickSort3Way {

    private QuickSort3Way(){};

    public static void sort(Comparable[] arr,int l,int r){

        // 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;  // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;  // arr[lt+1...gt - 1) == v
        while(i < gt) {
            if(arr[i].compareTo(v) < 0) {
                swap(arr,i,lt + 1);
                lt++;
                i++;
            }else if(arr[i].compareTo(v) > 0){
                swap(arr,i,gt - 1);
                gt--;
            }else {
                i++;
            }
        }
        swap(arr,i,l);

        sort(arr, l, lt-1);
        sort(arr, gt, r);

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
        SortTestHelper.testSort("cn.lzg.algo.quickSort.QuickSort3Way", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
