public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};


        merge(nums1, 3, nums2, nums2.length);
        displayArray(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        m--;
        n--;
        while( m >= 0 & n >=0){
            if(nums1[m] >= nums2[n]){
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }
        if(m < 0){
            while(n >= 0){
                nums1[k] = nums2[n];
                n--;
                k--;
            }
        } else {
            while(m >= 0){
                nums1[k] = nums1[m];
                m--;
                k--;
            }
        }
    }

    public static void displayArray(int[] array){
        for(int i: array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
