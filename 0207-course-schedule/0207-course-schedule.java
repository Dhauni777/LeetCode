class Solution {
    boolean dfs(int src, ArrayList<Integer>[] adj, int[] vis){
        if(vis[src]==0) return true;
        if(vis[src]==1) return false;

        vis[src]=0;

        for(int nbr:adj[src]){
            boolean cycle= dfs(nbr,adj,vis);
            if(cycle== true) return true;
        }
        vis[src]=1;
        return false;
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj= new ArrayList[n]; 
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge: prerequisites){
            int src=edge[1];
            int dst=edge[0];
            adj[src].add(dst);
        }
        int[] vis=new int[n];
        for(int i=0;i<n;i++){
            vis[i]=-1;
        }
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                boolean cycleDetect= dfs(i, adj, vis);
                if(cycleDetect==true) return false;
            }
        }
        return true;
    }
}