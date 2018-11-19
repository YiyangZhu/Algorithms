public class ConvertExcelTitle {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            System.out.println(convertToTitle(i));
        }

    }

    public static String convertToTitle(int n) {
        String result = "";
        while(n != 0){
            int i = n % 26 - 1;
            n = n / 26;
            if(i == -1){
                result = "Z" + result;
                n = n - 1;
            } else {
                result = (char)(i + (int)'A') + result;
            }

        }
        return result;

    }
}
