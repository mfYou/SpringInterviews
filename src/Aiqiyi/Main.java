package Aiqiyi;

import java.util.Scanner;

/**
 * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，他想让这个ID变成他的辛运ID，所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
 *
 * 如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
 *
 * 输入样例2
 * 000018
 *
 * 输出样例2
 * 1
 */

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String str = sn.nextLine();
        if (str.length()!=6) return;
        int[] nums = new int[str.length()];
        for (int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            nums[i] = Integer.parseInt(ch.toString());
        }
        int left = 0;
        int right = 0;
        for (int i=0; i<3; i++){
            left+=nums[i];
        }
        for (int i = 3; i<6; i++){
            right+=nums[i];
        }
        int tmp = Math.abs(left-right);
        int cha = left-right;
        if (tmp == 0){
            System.out.println(0);
            return;
        }
        if(tmp>=1&&tmp<=9){
            if ((checkOne(nums,cha))){
                System.out.println(1);
                return;
            }
            if (checkTwo(nums, cha)){
                System.out.println(2);
                return;
            }
            System.out.println(3);
            return;
        }
        if (tmp>=10&&tmp<=27){
            if (checkTwo(nums, cha)){
                System.out.println(2);
                return;
            }
            System.out.println(3);
        }
    }

    private static boolean checkOne(int[] nums, int target){
        if (target>0){
            for (int i =0; i<3;i++){
                if (nums[i] >= target) return true;
            }
            for (int i=3; i<6; i++){
                if ((9-nums[i]) >= target) return true;
            }
        }else {
            target = Math.abs(target);
            for (int i =0; i<3;i++){
                if ((9-nums[i]) >= target) return true;
            }
            for (int i=3; i<6; i++){
                if (nums[i] >= target) return true;
            }
        }
        return false;
    }

    private static boolean checkTwo(int[] nums, int target){
        if (target>0){
            for (int i =0; i<3; i++){
                for (int j=i+1; j<3; j++){
                    if ((nums[i]+nums[j])>=target) return true;
                }
            }
            for (int i=3; i<6; i++){
                for (int j=i+1; j<6; j++){
                    if (nums[i]+nums[j]<=(18-target)) return true;
                }
            }
            for (int i=0; i<3;i++){
                for (int j=3; j<6; j++){
                    if ((nums[i]+9-nums[j])>=target) return true;
                }
            }
        }else{
            target = Math.abs(target);
            for (int i =0; i<3; i++){
                for (int j=i+1; j<3; j++){
                    if (nums[i]+nums[j]<=(18-target)) return true;
                }
            }
            for (int i=3; i<6; i++){
                for (int j=i+1; j<6; j++){
                    if ((nums[i]+nums[j])>=target) return true;
                }
            }
            for (int i=0; i<3;i++){
                for (int j=3; j<6; j++){
                    if ((nums[j]+9-nums[i])>=target) return true;
                }
            }
        }
        return false;
    }
}
