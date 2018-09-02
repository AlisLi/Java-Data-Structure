package cn.lzg.algo.mergeSort;

import cn.lzg.algo.insertSort.InsertionSort;
import cn.lzg.algo.selectSort.SortTestHelper;

import java.util.Arrays;

/**
 * @author lzg
 * @date 2018/9/2 21:56
 * @desc 自底向上的归并排序 （即：将递归用循环编写）
 */
public class MergeSortBU {

    private MergeSortBU(){};

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

        int n = arr.length;

        // Merge Sort Bottom Up 无优化版本
//        for (int sz = 1; sz < n; sz *= 2)
//            for (int i = 0; i < n - sz; i += sz+sz)
//                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
//                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1));

        // Merge Sort Bottom Up 优化
        // 对于小数组(元素个数小于16), 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );

        for(int i = 16;i < n;i += i) {
            for(int j = 0;j < n - i;j += 2 * i){
                //对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if(arr[j + i - 1].compareTo(arr[j + i]) > 0){
                    merge(arr,j,j + i - 1,Math.min(j + 2 * i,n - 1));
                }
            }
        }

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
        SortTestHelper.testSort("cn.lzg.algo.mergeSort.MergeSortBU", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }


}
