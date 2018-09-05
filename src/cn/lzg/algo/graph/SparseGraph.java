package cn.lzg.algo.graph;

import java.util.Vector;

/**
 * @author lzg
 * @date 2018/9/5 13:42
 * @desc 稀疏图-邻接表的存储方式
 */
public class SparseGraph implements Graph {
    private int n;  //节点数
    private int m;  //边
    private boolean directed;   //是否为有向图
    private Vector<Integer>[] g;    //图的具体数据。Vector：向量类

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = new Vector[n];
        for(int i = 0;i < n;i++){
            g[i] = new Vector<Integer>();
        }
    }

    public int V(){ return n;} // 返回节点个数
    public int E(){ return m;} // 返回边的个数

    // 向图中添加一个边
    public void addEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        g[v].add(w);
        if(v != w && !directed){
            g[w].add(v);
        }
        m++;
    }

    // 验证图中是否有从v到w的边
    public boolean hasEdge(int v, int w){

        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for( int i = 0 ; i < g[v].size() ; i ++ )
            if( g[v].elementAt(i) == w )
                return true;
        return false;
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

}
