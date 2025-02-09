# february9_2025
The problem that i solved today in leetcode

1.You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i]. Return the total number of bad pairs in nums.

Code:
class Solution {
    public long countBadPairs(int[] nums) {
        long cnt=0;
        int n=nums.length,i,j;
        Map<Integer,Integer> m=new HashMap<>();
        for(i=0;i<n;i++)
        {
            int diff=i-nums[i];
            int good=m.getOrDefault(diff,0);
            cnt+=i-good;
            m.put(diff,good+1);
        }
        return cnt;
    }
}
