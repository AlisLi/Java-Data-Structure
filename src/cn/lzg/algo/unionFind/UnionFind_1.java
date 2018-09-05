package cn.lzg.algo.unionFind;

/**
 * @author lzg
 * @date 2018/9/5 9:27
 * @desc 并查集1：用数组表示
 */
public class UnionFind_1 {

    private int[] id;
    private int count;

    public UnionFind_1(int n) {
        this.count = n;

        id = new int[n];
        //初始化(每一个数据对应一个集合编号)：数据为i，集合编号为id[i]。id[i] = i
        for(int i = 0;i < n;i++){
            id[i] = i;
        }
    }

    //查找元素p所对应的集合编号
    private int find(int p) {
        assert p >=0 && p < count;
        return id[p];
    }

    //查看元素p和q是否属于一个集合
    //O(1)复杂度
    public boolean isConnected(int p,int q) {
        return find(p) ==find(q);
    }

    //合并元素p和q所对应的集合编号
    public void unionElements(int p,int q) {

        int pId = find(p);
        int qId = find(q);

        if(pId == qId){
            return;
        }

        //将集合编号为qId的集合合并到编号为pId中
        for(int i = 0;i < count;i++){
            if(id[i] == qId){
                id[i] = pId;
            }
        }
    }

}
