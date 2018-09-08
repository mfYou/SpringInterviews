package Alibaba;

/**
 * 已知正整数数组A，记为{a(1)，a(2)，a(3)，a(4) ...... a(n) ......}，
 * 数组中任一元素大小不超过10000，任意两个元素互不相同。
 * 现在按照以下规则尝试将数组A拆分成若干个(一个或者多个)子数组：
 *
 * A中任意一个元素a(n)必然出现于某个子数组中，且无论是子数组之间还是子数组内元素均不重复出现。
 * 对于任意一个子数组B，记为{b(1)，b(2)，b(3)，b(4) ...... b(n) ......}，B中任一元素b(i)，b(i)
 * 在数组A中对应的下标小于b(i+1)在数组A中对应的下标。（如果b(i+1)存在的话）
 * 对于任意一个子数组，数组长度大于等于3，同时其值按照子数组中的顺序构成一个等比或者等差数列。
 * 问题：
 * 求数组A符合以上条件拆分有多少种可能的组合，如不存在则返回0。
 *
 * 以数组 [ 1 2 3 4 5 6 ] 为例其可能的拆分为：
 * [ 1 2 3 ]
 * [ 4 5 6 ]
 *
 * [ 1 2 3 4 5 6 ]
 *
 * [ 1 3 5 ]
 * [ 2 4 6 ]
 * 则其可能的组合数为3.
 *
 * 以数组 [ 1 2 4 3 5 ] 为例则不存在这样的拆分，
 * 其可能的组合数为0.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n=sn.nextInt();
        int[] nums = new int[n];
        for (int i =0; i<n; i++){
            nums[i] = sn.nextInt();
        }
    }

    private static int getArrayCount(int[] nums){
        if (nums.length<3) return 0;
        return 0;
    }
}
