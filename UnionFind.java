/**
 * A implementation for Weighted Quick Union with path compression
 * See Week 1 of algs4part1 for details
 */
class UnionFind{
    
    int parent[];
    int sz[];
    int n;
    
    UnionFind(int n){
        parent = new int[n];
        sz = new int[n];
        this.n=n;
        int i = 0;
        for(i = 0; i < n; i++){
            parent[i]=i;
            sz[i]=1;
        }
    }
    
    int root(int a){
        int i = a;
        while(parent[i]!=i){
            parent[i]=parent[parent[i]];
            i=parent[i];
        }
        return i;
    }
    
    boolean connected(int a, int b){
        return root(a)==root(b);
    }
    
    void union(int a, int b){
        int ra,rb;
        ra = root(a);
        rb = root(b);
        if(ra==rb) return;
        if(sz[ra]<sz[rb]){
            parent[ra]=rb;
            sz[rb]+=sz[ra];
        }
        else{
            parent[rb]=ra;
            sz[ra]+=sz[rb];
        }
    }
}