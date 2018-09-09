package JD;
/**
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。对于这样的简单无向图，如果能将所有点划分成若干个集合，使得任意两个同一集合内的点之间没有边相连，任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
 * 第一行输入一个整数T表示数据组数，1≤T≤10。
 *
 * 每组数据格式为：
 *
 * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
 *
 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
 */

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int cir = sn.nextInt();
        for (int i=0; i<cir; ++i){
            int n = sn.nextInt();
            int m = sn.nextInt();
            List<Edge> edgeList = new ArrayList<>();
            Set<Integer> nodes = new HashSet<>();
            for (int j=0; j<m; ++j){
                int x = sn.nextInt();
                int y = sn.nextInt();
                Edge edge = new Edge(x,y);
                nodes.add(x);
                nodes.add(y);
                edgeList.add(edge);
            }
            System.out.println(edgeList.toString());
            System.out.println(judgeGraph(edgeList,nodes) ? "Yes":"No");
        }
    }

    static boolean judgeGraph(List<Edge> edgeList, Set<Integer> nodeList){
        if (nodeList.size() == 0) return false;
        Set<Integer> nodes = new HashSet<>();
        int start = edgeList.get(0).x;
        nodes.add(start);
        nodeList.remove(start);
        for (int i=0; i<nodeList.size(); i++){
            if (nodes.contains(edgeList.get(i).x)||nodes.contains(edgeList.get(i).y)){
                nodeList.remove(edgeList.get(i).x);
                nodeList.remove(edgeList.get(i).y);
                nodes.add(edgeList.get(i).y);
                nodes.add(edgeList.get(i).x);
            }
        }
//        System.out.println(nodes.size());
//        System.out.println(nodeList.size());
        if (nodeList.size()==0){
            return false;
        }else {
            return true;
        }
    }

    static class Edge{
        int x, y;
        Edge(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
