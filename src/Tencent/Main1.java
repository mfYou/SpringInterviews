package Tencent;

/**
 * 和谐数字，每位相加整除于原来的数字
 */

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        int[] nums = new int[t];
        for (int i=0; i<t; i++){
            nums[i] = sn.nextInt();
        }
        for (int i=0; i<nums.length; i++){
            check(nums[i]);
        }
    }

    private static void check(int num){
        if (num<=0) return;
        int temp = num;
        int count = 0;
        while (temp!=0){
            count+=temp%10;
            temp/=10;
        }
        if (num%count == 0){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
