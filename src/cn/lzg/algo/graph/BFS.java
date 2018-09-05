package cn.lzg.algo.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lzg
 * @date 2018/9/5 15:18
 * @desc 图的广度优先遍历
 */
public class BFS {

    private Graph G;
    private boolean[] visited;  // 记录dfs的过程中节点是否被访问

    public BFS(Graph g) {
        G = g;
        visited = new boolean[G.V()];
        for( int i = 0 ; i < G.V() ; i ++ ){
            visited[i] = false;
        }
    }

    // 图的广度优先遍历
    public void bfs(){
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i = 0;i < visited.length;i++){
            if(!visited[i]){
                visited[i] = true;
                for(int j : G.adj(i)){
                    queue.add(j);
                }
                while (!queue.isEmpty()){
                    int k = queue.remove();
                    visited[k] = true;
                    for(int s : G.adj(k)){
                        queue.add(s);
                    }
                }
            }
        }
    }

}
