package Ctrip;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        long num = sn.nextLong();
        int count = 0;
        while (num > 0){
            if ((num&1)==1){
                count+=1;
            }
            num = num>>1;
        }
        System.out.println(count);
    }
}
