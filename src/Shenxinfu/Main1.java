package Shenxinfu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = sn.nextInt();
        }
        int min = nums[0];
        int index_x = 0;
        for (int i=0; i<n; i++){
            if (min+nums[i]<min){
                min = min+nums[i];
            }
            if (min-nums[index_x]<min){
                index_x++;
                min = min-nums[index_x];
            }
        }
        System.out.println(min);
    }
}
