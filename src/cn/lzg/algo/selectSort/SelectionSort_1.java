package cn.lzg.algo.selectSort;

/**
 * 选择排序
 * 只能对int排序
 */
public class SelectionSort_1 {

    // 我们的算法类不允许产生任何实例
    private SelectionSort_1(){}
    /**
     * 选择排序
     * 升序排列
     * @param arr
     */
    public static void sort(Comparable[] arr){

        int n = arr.length;

        for(int i = 0;i < n;i++){
            int minIndex = i;
            for(int j = i + 1;j < n;j++){
                if(arr[minIndex].compareTo(arr[j]) > 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    /**
     * 通过下标交换数组中的两个值
     * @param arr
     * @param i   当前交换值的下值
     * @param j  最小值的下标
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
        SortTestHelper.testSort("cn.lzg.algo.selectSort.SelectionSort_1", arr);

        return;
    }

    public static void main(String[] args) {
        test();
        testTime();
    }

}
