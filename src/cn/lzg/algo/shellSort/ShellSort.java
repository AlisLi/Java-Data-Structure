package cn.lzg.algo.shellSort;

import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * 希尔排序
 */
public class ShellSort {

    private ShellSort(){};

    public static void sort(Comparable[] arr){

        int n = arr.length;

        int h = 1;
        // h = 1, 4, 13, 40, ...
        // h 是希尔排序时的每次跳跃的间隔
        while (h < n/3){
            h = h * 3 + 1;
        }

        //循环依间隔大小依次递减，直到间隔为1
        while(h >= 1) {
            //对相隔为h的一组数据使用n - h插入排序,
            // i是每次插入排序的起点
            for(int i = h; i < n;i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for(;j >= h && e.compareTo(arr[j - h]) < 0; j -= h){
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }

            h = h / 3;
        }

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
        SortTestHelper.testSort("cn.lzg.algo.shellSort.ShellSort", arr);

        return;
    }

    // 测试InsertionSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
