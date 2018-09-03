package cn.lzg.algo.heapSort;

/**
 * @author lzg
 * @date 2018/9/3 14:55
 * @desc 最大堆的基本存储
 */
// 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;    //堆中的数据
    protected int count;  //堆中当前元素的个数
    protected int capacity;   //堆的容量

    //构造函数，构造一个空堆，可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public MaxHeap(Item arr[]){

        int n = arr.length;

        data = (Item[])new Comparable[n+1];
        capacity = n;

        for( int i = 0 ; i < n ; i ++ ) {
            data[i+1] = arr[i];
        }
        count = n;

        //完全二叉树：叶子节点个数 = 总节点数 / 2 或者 叶子节点个数 = 总节点数 / 2 + 1
        for( int i = count/2 ; i >= 1 ; i -- ){
            shiftDown(i);
        }

    }

    //返回堆中元素的个数
    public int size() {
        return count;
    }

    //返回一个布尔值，判断堆中是否有元素
    public boolean isEmpty() {
        return count==0;
    }

    //给最大堆插入一个元素
    public void insert(Item item) {
        assert count + 1 <= capacity;
        //将data[0] 空掉，方便计算
        data[count + 1] = item;
        count++;
        shifitUp(count);

    }

    //取出堆顶的元素,即堆中的最大的元素
    public Item extractMax() {
        assert count > 0;
        Item ret = data[1];

        //将第一个元素和最后一个元素交换
        swap(1,count);
        //将第一元素删除
        count--;
        //自顶向下整理堆
        shiftDown(1);

        return ret;
    }

    public void shiftDown(int k) {

        while(2 * k <= count) {
            int j = 2 * k;
            if(j + 1 <= count && data[j].compareTo(data[j + 1]) < 0){
                j++;
            }
            if(data[k].compareTo(data[j]) >= 0){
                break;
            }
            swap(k,j);
            k = j;
        }
    }

    /**
     * 交换堆中的下标为i和j的元素
     * @param i
     * @param j
     */
    public void swap(int i,int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //********************
    //* 最大堆核心辅助函数
    //* 将新插入的元素向上放到合适的位置
    //* 遵循的规则：堆中的节点一定大于子节点
    //********************
    public void shifitUp(int k) {
        //当前插入的新节点，大于父节点则进行交换
        while(k > 1 && data[k / 2].compareTo(data[k]) < 0){
            swap(k,k / 2);
            k = k / 2;
        }
    }

    //测试MaxHeap
    public static void main(String[] arg){
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }
}
