public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {4,5,6};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        return findMedian(nums1, 0, len1 - 1, nums2, 0, len2 - 1);

    }

    public static double findMedian(int[] arr1, int low1, int high1, int[] arr2, int low2, int high2) {
        if ((high1-low1)+1 == 2 && (high2-low2)+1 == 2) {
            return (Math.max(arr1[low1], arr2[low2]) + Math.min(arr1[high1], arr2[high2])) / 2.0;
        }
        if(high1-low1 == 0){
            return median(arr2,low2 , high2);
        }
        if(high2-low2 == 0){
            return median(arr1,low1 , high1);
        }
        double m1 = median(arr1, low1, high1);
        double m2 = median(arr2, low2, high2);
        if (m1 == m2) {
            return m1;
        } else {
            if (m1 > m2) {
                return findMedian(arr1, low1, (high1 - low1) / 2 + low1, arr2, (high2 - low2) / 2 + low2, high2);
            } else {
                return findMedian(arr1, (high1 - low1) / 2 + low1, high1, arr2, low2, (high2 - low2) / 2 + low2);
            }
        }
    }

    public static double median(int[] arr, int low, int high) {
        int indexMiddle = (high - low) / 2 + low;
        if ((high - low) % 2 == 0) {
            return arr[indexMiddle];
        } else {
            return (arr[indexMiddle] + arr[indexMiddle + 1]) / 2.0;
        }
    }
}
