package MS;

import java.util.HashSet;

public class LongestSubstringNoRepeat {
    public static void main(String[] args) {
        String s1 = "abcacdefg";
        System.out.println(lengthOfLongestSubstring(s1));
    }

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if(s == null || s.length() < 1){
            return result;
        }
        int k = 0;
        //loop invariant: length between k to i is the current max length; max is the max length before i;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);
            System.out.print("i="+i+"\tc="+c);
            if(!set.contains(c)){
                set.add(c);
                System.out.print("\tset="+set);
                result = Math.max(set.size(), result);
                System.out.print("\tset.size()="+set.size()+"\tresult="+result);
            } else {
                while(k < i){
                    System.out.print("\tk="+k+"\ti="+i);
                    System.out.print("\ts.charAt(k)="+s.charAt(k)+"\tset="+set);
                    if(s.charAt(k) == c){
                        k++;
                        break;
                    } else {
                        set.remove(s.charAt(k));
                        k++;
                    }
                }
            }
            System.out.println();
        }
        return result;
    }


}
