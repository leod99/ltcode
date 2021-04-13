//lintcode 1083
//https://www.lintcode.com/problem/1083/
public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: three non-overlapping subarrays with maximum sum
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Write your code here
        int n = nums.length;
        int[] w = new int[n - k +1];
        int cur = 0;
        for(int i=0;i<n; i++){
            cur += nums[i];
            if(i>=k){
                cur -= nums[i-k];
            }
            if(i>=k-1){
                w[i-k+1] = cur;
            }
        }
        
        int[] left = new int[w.length];
        int[] right = new int[w.length];
        int best = 0; //index
        for(int i=0; i< w.length; i++){
            if(w[i]>w[best]){
                best = i;
            }
            left[i] = best;
        }
        best = w.length-1;
        for(int i=w.length-1; i>=0; i--){
            if(w[i] >= w[best]){
                best = i;
            }
            right[i] = best;
        }
        int[] ans = {-1, -1, -1};
        for(int j= k; j< w.length -k; j++){
            int i = left[j-k], l = right[j+k];
            if(ans[0] == -1 || w[i]+w[j]+ w[l]> w[ans[0]]+ w[ans[1]]+w[ans[2]]){
                ans[0] = i;
                ans[1] = j;
                ans[2] = l;
            }
        }
        return ans;
    }
}
