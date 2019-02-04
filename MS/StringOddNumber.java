package MS;

public class StringOddNumber {
    public static void main(String[] args) {
        String string1 = "I am a student";

        System.out.println(countOdd(string1));

    }

    public static int countOdd(String string1){
        int count  = 0;
        String[] stringArray = string1.trim().split(" ");
        for(String s: stringArray){
            if(s.length() % 2 != 0){
                count++;
            }
        }
        return count;
    }
}
