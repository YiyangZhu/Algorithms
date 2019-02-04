package MS;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s,numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int step = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows;i++){
            if(i == 0 || i == numRows - 1){
                int j = i;
                while(j < s.length()){
                    sb.append(s.charAt(j));
                    j += step;
                }
            } else {
                int step1 = 2 * (numRows - i - 1);
                int step2 = step - step1;
                int j = i;
                boolean flag = true;
                while(j < s.length()){
                    sb.append(s.charAt(j));
                    if(flag){
                        j += step1;
                    } else {
                        j += step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();

    }
}
