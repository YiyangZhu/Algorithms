public class MergeSortedArray {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        m--;
        n--;
        for(i = nums1.length - 1; i >= 0;i--){
            if(m == -1 || n == -1){
                break;
            }
            if(nums1[m] > nums2[n]){
                nums1[i] = nums1[m];
                m--;
            } else {
                nums1[i] = nums2[n];
                n--;
            }
        }
        if(m == -1){
            while(n != -1){
                nums1[i] = nums2[n];
                i--;
                n--;
            }
        }

        return nums1;
    }
}