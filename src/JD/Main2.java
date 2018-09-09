package JD;
/**
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 *
 * 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 *输入
 * 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。
 * 输出
 * 输出包含一个整数，表示不合格品的数量。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        List<Stuff> stuffs = new ArrayList<>();
        for (int i=0; i<n; i++){
            int x = sn.nextInt();
            int y = sn.nextInt();
            int z = sn.nextInt();
            stuffs.add(new Stuff(x,y,z));
        }
        int count = 0;
        boolean[] check = new boolean[stuffs.size()];
        Arrays.fill(check, true);
        for (int i=0; i<stuffs.size(); i++){
           for (int j=i+1; j<stuffs.size(); j++){
               if (stuffs.get(i).x<stuffs.get(j).x&&stuffs.get(i).y<stuffs.get(j).y&&stuffs.get(i).z<stuffs.get(j).z){
                   check[i] = false;
               }
               if (stuffs.get(j).x<stuffs.get(i).x&&stuffs.get(j).y<stuffs.get(i).y&&stuffs.get(j).z<stuffs.get(i).z){
                   check[j] = false;
               }
           }
        }
        for (int i=0; i<check.length; i++){
            if (!check[i]) count++;
        }
        System.out.println(count);
    }

    static class Stuff{
        int x;
        int y;
        int z;
        Stuff(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
