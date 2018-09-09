package ByteDance;


import java.util.*;

public class Main5 {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = sn.nextInt();
        int m = sn.nextInt();
        List<Relation> relations = new ArrayList<>();
        Map<Integer, Boolean> users = new HashMap<>();
        for (int i=0; i<2*m; i+=2){
            int user = sn.nextInt();
            int atten = sn.nextInt();
            users.put(atten, false);
            users.put(user, false);
            Relation relation = new Relation(user, atten);
            relations.add(relation);
        }
        int count = 0;
        for (Map.Entry<Integer, Boolean> entry:users.entrySet()){
            if (isPopular(entry.getKey(),n, users, relations)) count++;
        }
        System.out.println(count);
    }

    static boolean isPopular(int user,int n,  Map<Integer, Boolean> users, List<Relation> relations){
        if (users.get(user)) return true;
        for (int i=0; i<relations.size(); i++){
            if (relations.get(i).atten==user&&users.get(relations.get(i).user)) return true;
        }
        if (getAllFans(user, relations) == n-1){
            return true;
        }
        return false;
    }

    static int getAllFans(int user, List<Relation> relations){
        Map<Integer, Boolean> fans = new HashMap<>();
        for (int i=0; i<relations.size(); i++){
            if (relations.get(i).atten == user){
                fans.put(relations.get(i).user,true);
                fans.putAll(getFans(relations.get(i).user, relations));
            }
        }
        if (fans.get(user)!=null) return fans.size()-1;
        return fans.size();
    }

    static Map<Integer,Boolean> getFans(int user, List<Relation> relations){
        Map<Integer, Boolean> fans = new HashMap<>();
        for (int i=0; i<relations.size(); i++){
            if (relations.get(i).atten == user) fans.put(relations.get(i).user, true);
        }
        return fans;
    }

    static class Relation{
        int user, atten;
        Relation(int user, int atten){
            this.user = user;
            this.atten = atten;
        }
    }
}
