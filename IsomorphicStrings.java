import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s1 = "abb";
        String t1 = "cdd";
        String s2 = "abb";
        String t2 = "zyx";
        String s3 = "ab";
        String t3 = "aa";
        //System.out.println(isIsomorphic(s1, t1));
        //System.out.println(isIsomorphic(s2, t2));
        System.out.println(isIsomorphic(s3,t3 ));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            map.keySet();
            map.values();
            System.out.println(map.keySet());
            System.out.println(map.values());
            if(map.containsKey(s.charAt(i))){
                System.out.println(map.get(s.charAt(i)));
                System.out.println(t.charAt(i));
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            } else {
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }

        }
        return true;

    }
}
