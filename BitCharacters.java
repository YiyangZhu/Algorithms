public class BitCharacters {

    public static void main(String[] args) {
        int[] bits ={1,0,0};

        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        if(bits == null || bits.length < 1){
            return false;
        }
        if(bits.length == 1){
            return true;
        }
        int i = 0;
        for(i = 0; i < bits.length;i++){
            if(bits[i] == 1){
                i += 1;
                System.out.println(i);
                if(i == bits.length-1){
                    return false;
                }

            }
        }

        System.out.println("i="+i);
        return true;
    }
}
