package BS;

public class FirstBadVersion {
    //n2 can be initialized to different numbers
    int n2 = 0;
    public int firstBadVersion(int n) {
        if(n == 0){
            return 0;
        }

        int left = 0;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                if(!isBadVersion(mid-1)){
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return right + 1;
    }

    //isBadVersion is API
    public boolean isBadVersion(int n){
        if(n >= n2){
            return true;
        } else {
            return false;
        }
    }
}
