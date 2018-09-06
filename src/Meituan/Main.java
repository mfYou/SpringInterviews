package Meituan;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * 给定一张包含N个点、N-1条边的无向连通图，节点从1到N编号，每条边的长度均为1。假设你从1号节点出发并打算遍历所有节点，那么总路程至少是多少？
 */
public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = Integer.parseInt(sn.nextLine());
        System.out.println(n);
        int[][] dis = new int[n+1][n+1];
        for (int i=1; i<n; i++){
            for (int j=i+1; j<n; j++){
                dis[i][i] = 0;
                dis[i][j] = 2*n;
                dis[j][i] = 2*n;
            }
        }
        for (int i=0; i<n-1; i++){
            String[] str = sn.nextLine().split(" ");
            System.out.println(Arrays.toString(str));
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            dis[x][y] = 1;
            dis[y][x] = 1;
        }

        int min = (n-1)*2*n;

    }
//
//    private static int minLen(int[][] dis){
//        int [] vis = new int[dis.length];
//        for (int i=1; i<dis.length; i++){
//            vis[i] = 0;
//        }
//        vis[1] = 1;
//
//    }

    private static void breadthFirst(Edge root){
        Queue<Edge> queue = new ArrayDeque<>();
        queue.add(root);
    }

    static class Edge{
        private int val;
        private Edge next;
        public Edge(int k){
            this.val = k;
            this.next = null;
        }

        public void setNext(Edge next) {
            this.next = next;
        }
    }
}
