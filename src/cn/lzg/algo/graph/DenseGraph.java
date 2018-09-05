package cn.lzg.algo.graph;

import java.util.Vector;

/**
 * @author lzg
 * @date 2018/9/5 11:16
 * @desc 稠密图-邻接矩阵的存储方式
 */
public class DenseGraph implements Graph {

    private int n;  //节点数
    private int m;  //边数
    private boolean directed;   // 是否为有向图
    private boolean[][] g;      // 图的具体数据

    //构造函数
    public DenseGraph(int n,boolean directed){
        assert n > 0;
        this.n = n;
        this.m = 0; //初始时没有边
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任何边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
    }

    //返回节点个数
    public int V(){
        return this.n;
    }

    //返回边的个数
    public int E(){
        return this.m;
    }

    //像图中增加一条边
    public void addEdge(int v,int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if(hasEdge(v,w)){
            return;
        }

        g[v][w] = true;
        if(!directed){
            //如果无向，增加另一条边
            g[w][v] = true;
        }
        m++;
    }

    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w];
    }

    //返回途中所有顶点的所有的邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] )
                adjV.add(i);
        return adjV;
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

}
