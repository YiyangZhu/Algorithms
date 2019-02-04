package MS;

public class StringReverse {
    public static void main(String[] args) {
        String s1 = "The sky is blue";
        //System.out.println(reverseWords(s1));
        StringBuilder sb1 = new StringBuilder();
        String[] array1 = s1.split(" ");
        for(String s: array1){
            System.out.print(s+" ");
        }
        String[] array2 = new String[array1.length];
        for(int i = 0; i < array2.length;i++){
            array2[i] = array1[array1.length-1-i];
        }
        for(String s: array2){
            System.out.print(s+" ");
        }


    }

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        s = s.trim();
        if (s == "") {
            return "";
        }
        String[] words = s.split(" ");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            words[i] = words[i].trim();
            System.out.println(words[i]);
            if(words[i].equals("")){
                continue;
            }
            result = result + " "+words[i];
            System.out.println(result);
        }
        result = result.trim();
        return result;
    }
}
