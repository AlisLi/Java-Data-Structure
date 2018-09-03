package cn.lzg.algo.heapSort;

import cn.lzg.algo.selectSort.SortTestHelper;

/**
 * @author lzg
 * @date 2018/9/3 18:48
 * @desc 使用额外的最大堆的堆排序
 */
public class HeapSort_1 {

    private HeapSort_1(){};

    // 对整个arr数组使用HeapSort1排序
    // HeapSort1, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
        for(int i = 0;i < n;i++) {
            maxHeap.insert(arr[i]);
        }
        //循环取出，排序为升序排列
        for(int i = n - 1;i >= 0;i--){
            arr[i] = maxHeap.extractMax();
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
        SortTestHelper.testSort("cn.lzg.algo.heapSort.HeapSort_1", arr);

        return;
    }

    // 测试HeapSort
    public static void main(String[] args) {
        test();
        testTime();
    }

}
