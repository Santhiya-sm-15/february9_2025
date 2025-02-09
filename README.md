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

2.You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target. We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Code:
class Solution {
    ArrayList<int[]>[] adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj=new ArrayList[n+1];
        int i;
        for(i=1;i<=n;i++)
            adj[i]=new ArrayList<>();
        for(int[] x:times)
            adj[x[0]].add(new int[]{x[1],x[2]});
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{0,k});
        while(!pq.isEmpty())
        {
            int[] x=pq.poll();
            int u=x[1];
            int dis=x[0];
            for(int[] a:adj[u])
            {
                int v=a[0];
                int d=a[1];
                if(dis+d<dist[v])
                {
                    dist[v]=dis+d;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        int max=0;
        for(i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
                return -1;
        }
        for(i=1;i<=n;i++)
            max=Math.max(max,dist[i]);
        return max;
    }
}
