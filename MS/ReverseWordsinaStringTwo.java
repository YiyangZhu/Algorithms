package MS;

public class ReverseWordsinaStringTwo {


    /*
    Given s = "the sky is blue",
    return "blue is sky the".
     */
    public String reverseWords(String s) {
        String result = "";
        String[] arr = s.split(" ");
        int i = 0;
        while(i < arr.length/2){
            String temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(String each: arr){
            sb.append(each);
            sb.append(" ");
        }
        System.out.println("sb="+sb);
        result = sb.toString();
        return result.substring(0,result.length()-1);
    }
}
