package Bilibili;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (n>2){
            if (n%2==0){
                stack.push(3);
                n=(n-2)/2;
            }else{
                stack.push(2);
                n=(n-1)/2;
            }
        }
        if (n==2){
            stack.push(3);
        }else if (n==1){
            stack.push(2);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
