public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("[.]");
        System.out.println("arr1.length = "+arr1.length);
        for(String s: arr1){
            System.out.println("arr1 is:");
            System.out.println(s);
        }
        return 0;

    }
}
