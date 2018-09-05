package cn.lzg.algo.unionFind;

/**
 * @author lzg
 * @date 2018/9/5 9:48
 * @desc 并查集2：用树的形式来表示
 */
public class UnionFind_2 {

    //使用一个数组构建一棵指向父节点的树
    //parent[i] 表示第i个元素所指向的父节点，当i = parent[i]时，parent[i]为集合编号
    private int[] parent;
    private int count;

    public UnionFind_2(int count) {
        parent = new int[count];
        this.count = count;
        // 初始化, 每一个parent[i]指向自己, 表示每一个元素自己自成一个集合
        for( int i = 0 ; i < count ; i ++ )
            parent[i] = i;
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(h)复杂度, h为树的高度
    private int find(int p){
        assert p >= 0 && p < count;
        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while(p != parent[p]){
            p = parent[p];
        }

        return parent[p];
    }

    //查看p，q是否为同一集合
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }

    // 合并元素q所在的集合到元素p所属的集合
    // O(h)复杂度, h为树的高度
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }

        parent[qRoot] = pRoot;
    }



}
