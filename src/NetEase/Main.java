package NetEase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String string = sn.nextLine();
        String temp = sn.nextLine();
        List<Character> array = new ArrayList<>();
        List<Character> temps = new ArrayList<>();
        for (int i=0; i<string.length(); i++){
            array.add(string.charAt(i));
        }
        for (int i=0; i<temp.length(); i++){
            temps.add(temp.charAt(i));
        }
        int result = minStep(array, temps, 0);
        System.out.println(result);
    }

    private static int minStep(List<Character> array, List<Character> temps, int index){
        if (index>=array.size()) return temps.size()-array.size();
        if (index>=temps.size()) return array.size()-temps.size();
        if (temps.get(index).equals(array.get(index))) return minStep(array, temps, index+1);
        List<Character> list1 = new ArrayList<>(temps);
        List<Character> list2 = new ArrayList<>(temps);
        list1.add(index, array.get(index));
        list2.remove(index);
        return Math.min(2+minStep(array,temps,index+1),1+Math.min(minStep(array, list1, index+1), minStep(array, list2, index)));
    }
}
