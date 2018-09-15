package Aiqiyi;

/**
 * 局长有N种食物，每种食物有Ai份。
 *
 * 每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
 *
 * 现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）
 *
 * N,M,P<=100,Ai<=1000
 *
 * 第一行N M P
 *
 * 第二行N个数Ai
 *
 * 接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int m = sn.nextInt();
        int p = sn.nextInt();
        if (p>n) return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=1; i<=n; i++){
            int tmp = sn.nextInt();
            map.put(i,tmp);
        }
        for (int i=0; i<m; i++){
            String eat = sn.next();
            int type = sn.nextInt();
            switch (eat){
                case "A":
                    int num = map.get(type);
                    num+=1;
                    map.put(type, num);
                    break;
                case "B":
                    int num1 = map.get(type);
                    if (num1 <= 0){
                        return;
                    }else {
                        num1-=1;
                        map.put(type, num1);
                    }
                    break;
            }
        }
        int max = map.get(p);
        int result = 1;
        for (Integer i:map.keySet()){
            if (map.get(i)>max){
                result+=1;
            }
        }
        System.out.println(result);
    }
}
