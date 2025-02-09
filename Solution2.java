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