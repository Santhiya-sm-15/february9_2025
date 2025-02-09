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