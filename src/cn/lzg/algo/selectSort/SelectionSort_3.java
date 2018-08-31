package cn.lzg.algo.selectSort;

/**
 * 改进的选择排序
 * 每次循环同时找出最大值和最小值
 */
public class SelectionSort_3 {

    /**
     * 选择排序
     * 升序排列
     * @param arr
     */
    public static  void sort(Comparable[] arr){

        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int minIndex = left;
            int maxIndex = right;

            //开始应该确保 left的值小于right
            if(arr[left].compareTo(arr[right]) > 0){
                swap(arr,left,right);
            }

            for(int i = left;i < right;i++){
                if(arr[i].compareTo(arr[minIndex]) < 0){
                    minIndex = i;
                }else if(arr[i].compareTo(arr[maxIndex]) > 0){
                    maxIndex = i;
                }
            }

            swap(arr,left,minIndex);
            swap(arr,right,maxIndex);

            left++;
            right--;

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
        SortTestHelper.testSort("cn.lzg.algo.selectSort.SelectionSort_3", arr);

        return;
    }

    public static void main(String[] args) {
        test();
        testTime();
    }



}
