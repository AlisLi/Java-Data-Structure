package cn.lzg.algo.mergeSort;

import cn.lzg.algo.insertSort.InsertionSort;
import cn.lzg.algo.selectSort.SortTestHelper;

import java.util.Arrays;

/**
 * @author lzg
 * @date 2018/9/2 21:45
 * @desc 优化的归并排序
 */
public class MergeSortBetter {

    private MergeSortBetter(){};

    //将arr[l...mid]和arr[mid + 1...r]结合
    public static void merge (Comparable[] arr,int l,int mid,int r) {
        Comparable[] temp = Arrays.copyOfRange(arr,l,r + 1);

        int i = l,j = mid + 1;
        for(int k = l;k <= r;k++){
            if(i > mid) {
                //如果左半部分元素已经取完，加入剩下的右半部分元素
                arr[k] = temp[j - l];
                j++;
            }else if(j > r){
                //如果右半部分元素已经取完，加入剩下的左半部分元素
                arr[k] = temp[i - l];
                i++;
            }else if(temp[i - l].compareTo(temp[j - l]) < 0){
                //如果左边的值小于右边的值，则加入左边的值
                arr[k] = temp[i - l];
                i++;
            }else {
                //如果右边的值小于左边的值，则加入右边的值
                arr[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void sort(Comparable[] arr,int l,int r){
        // 优化1: 对于小规模数组, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        sort(arr,l,mid);
        sort(arr,mid + 1,r);

        // 优化2: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if( arr[mid].compareTo(arr[mid+1]) > 0 )
            merge(arr, l, mid, r);
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
        SortTestHelper.testSort("cn.lzg.algo.mergeSort.MergeSortBetter", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }
}
