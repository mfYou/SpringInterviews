package Shenxinfu;
/**
 * 背包问题，二维数组，没行最多能用x次，求每列之和最大
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        HashMap<int[][], Integer> map = new HashMap<>();
        for (int i=0; i<t; i++){
            int m = sn.nextInt();
            int n = sn.nextInt();
            int x = sn.nextInt();
            int[][] temps = new int[m][n];
            for (int j=0; j<m; j++){
                for (int k=0; k<n;k++){
                    temps[j][k] = sn.nextInt();
                }
            }
            map.put(temps, x);
        }
        for (int[][] nums:map.keySet()){
            int x = map.get(nums);
            System.out.println(getMax(nums, x));
        }
    }

    public static int getMax(int[][] nums, int x){
        return x;
    }
}
