package cn.lzg.algo.binarySearchTree;

/**
 * @author lzg
 * @date 2018/9/3 20:49
 * @desc 递归的二分查找算法
 */
public class BinarySearch_2 {

    private BinarySearch_2(){};

    public static int find(Comparable[] arr,int l,int r,Comparable target) {

        if(l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if(target.compareTo(arr[mid]) == 0) {
            return mid;
        }else if(target.compareTo(arr[mid]) > 0) {
            return find(arr,mid + 1,r,target);
        }else {
            return find(arr,l,mid - 1,target);
        }

    }

    public static int find(Comparable[] arr,Comparable target){

        int n = arr.length;

        return find(arr,0,n - 1,target);

    }

    // 测试递归的二分查找算法
    public static void main(String[] args) {

        int N = 100;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = find(arr, new Integer(i));
            if (i < N)
                System.out.println(v == i);
            else
                System.out.println(v == -1);
        }

        return;
    }

}
