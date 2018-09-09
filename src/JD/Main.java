package JD;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );

        int t = sc.nextInt();
        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] graph = new int[n][n];

            for (int j = 0; j < m; ++j) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                graph[v1 - 1][v2 - 1] = 1;
                graph[v2 - 1][v1 - 1] = 1;
            }

            System.out.println(isAbsoluteGraph(graph) ? "Yes" : "No");
        }
    }

    public static boolean isAbsoluteGraph(int[][] graph) {
        int j = 0;
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();
        while (temp.size() != graph.length) {
            ArrayList<Integer> set = new ArrayList<>();
            set.add(j);
            temp.add(j);
            for (int i = 0; i < graph.length; ++i) {
                if (i != j && !temp.contains(i) && graph[j][i] != 1) {
                    set.add(i);
                    temp.add(i);
                }
            }

            sets.add(set);

            for (int i = 0; i < graph.length; ++i) {
                if (!temp.contains(i)) {
                    j = i;
                }
            }
        }

        for (int i = 0; i < sets.size(); ++i) {
            for (int k = 0; k < sets.size(); ++k) {
                if (i != k) {
                    for (int m : sets.get(i)) {
                        for (int n : sets.get(k)) {
                            if (graph[m][n] == 0) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
